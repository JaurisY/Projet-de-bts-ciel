package com.example.projetstage.composables

import android.annotation.SuppressLint
import android.util.Size
import android.webkit.URLUtil
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.BinaryBitmap
import com.google.zxing.DecodeHintType
import com.google.zxing.MultiFormatReader
import com.google.zxing.PlanarYUVLuminanceSource
import com.google.zxing.common.HybridBinarizer
import java.nio.ByteBuffer
import androidx.compose.ui.platform.LocalUriHandler
// /_> composables

@SuppressLint("SuspiciousIndentation")
@Composable
fun QRcodeScreen() {

    var code by remember { mutableStateOf("") } // qr code sous forme de string.
    val hasReadCode: MutableState<Boolean> =
        remember { mutableStateOf(false) } // Variable de condition.

    val cameraProviderFeature = ProcessCameraProvider.getInstance(LocalContext.current) // Pour paramétrer la caméra.
    val selector = CameraSelector.Builder()  // Pour utiliser la caméra au dos du téléphone.
        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
        .build()

    val lifecycleOwner = LocalLifecycleOwner.current // Pour avoir l'etat du cycle de vie.

    val preview = Preview.Builder().build()  // Pour construir une class.

    val previewView = PreviewView(LocalContext.current) // Pour des soucis de compatibilité liés à jetpack compose.
        preview.setSurfaceProvider(previewView.surfaceProvider)

    AndroidView(
        factory = { androidViewContext ->

            val imageAnalysis = ImageAnalysis.Builder()  // Valeur pour le scanner.
                .setTargetResolution(Size(previewView.width, previewView.height))
                .setBackpressureStrategy(STRATEGY_KEEP_ONLY_LATEST)
                .build()

            imageAnalysis.setAnalyzer( // Met en place le scanner.
                ContextCompat.getMainExecutor(androidViewContext)
            ) { image ->

                val bytes = image.planes.first().buffer.toByteArray() // Définit l'unitée du scanner.

                val source = PlanarYUVLuminanceSource( // Définir les paramétres de binaryBmp.
                    bytes,
                    image.width,
                    image.height,
                    0,
                    0,
                    image.width,
                    image.height,
                    false
                )

                val binaryBmp = BinaryBitmap(HybridBinarizer(source)) // Définit binaryBmp.

                try {  // Action qui essaye de s'exécuter.
                    val result = MultiFormatReader().apply { // Définit les paramètres du scanner.
                        setHints(
                            mapOf(
                                DecodeHintType.POSSIBLE_FORMATS to arrayListOf(  // Précise le format utilisé.
                                    BarcodeFormat.QR_CODE // Le format QR code est ajouté.
                                )
                            )
                        )
                    }.decode(binaryBmp)
                    code = result.text  // Définit le QR code en format text.
                    hasReadCode.value = true }  // Change la valeur hasReadCode en true.

                catch (e: Exception) { // Action qui se déclenche seulement si le try n'a pas eu lieu.
                    e.printStackTrace() } // Fait crash l'application (écran noir).

                finally {  // variable utilisé pour appliqué les paramètres.
                    image.close()
                }
            }

            try {
                cameraProviderFeature.get() // lance la caméra.
                    .bindToLifecycle(lifecycleOwner, selector, preview, imageAnalysis) // Avec comme argument le scanner, la sélection de la caméra ...
            } catch (e: Exception) { // Action qui se déclenche seulement si le try n'a pas eu lieu.
                e.printStackTrace() // Fait crash l'application (écran noir).
            }
            previewView // Pour placer la caméra sur l'écran.
           },
            modifier = Modifier.fillMaxSize() // Mise en page.
    )

    if (hasReadCode.value) { // Condition qui regarde si un QR code a été lu.

        if (URLUtil.isValidUrl(code) && code.contains("https://www.bsoft")) { // Condition qui regarde si le QR code est
            OpenBrowser(code) // Appelle la fonction OpenBrowser.                   // vérifié et qu'il a pour nom de domaine bsoft.
        } else {
            AlertQRcode(onQRcode = { // Appelle la fonction AlertQRcode.
                hasReadCode.value = false // Boutton de la fonction AlertQRcode qui repasse la valeur
            })                            // hasReadCode à false ce qui nous fait retourner avant le if.
        }
    }
}

@Composable
fun OpenBrowser(code: String) { // Fonction pour rediriger sur une page internet.
    val loadURL = LocalUriHandler.current // Action qui permet d'ouvrir un navigateur.
    loadURL.openUri(code) // Précise l'URL du QR code.
}

private fun ByteBuffer.toByteArray(): ByteArray { // Fonction qui convertis des ByteBuffer en ByteArray.
    rewind()
    return ByteArray(remaining()).also { // Renvoi des ByteArray.
        get(it)
    }
}
