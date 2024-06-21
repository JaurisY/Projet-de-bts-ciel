package com.example.projetstage

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.projetstage.composables.AlertPermissionAccept
import com.example.projetstage.composables.AlertPermissionDenied
import com.example.projetstage.composables.App
import kotlin.system.exitProcess

// /_> composables

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { // Première action quand l'application se lance.
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Pour le mode sombre du téléphone.
        updateUi() // Appelle la fonction updateUI().
    }
    private fun updateUi() {
        setContent {
            when (PackageManager.PERMISSION_GRANTED) { // Condition qui regarde si les permitions à la caméra sont active.
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) -> {
                    App()
                }
                else -> {
                    cameraPermissionRequest.launch(Manifest.permission.CAMERA) // Action qui demande les permition à la caméra.
                }
            }
        }
    }

    private val cameraPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted -> // Demande les permissions.
            if (isGranted) { // Si accordé.
                setContent {
                    AlertPermissionAccept(onRestartApp = ::updateUi) // Appelle la fonction AlertPermissionAccept() qui peut lancer la fonction updateUI().
                }
            } else { // Si refusé.
                setContent {
                    AlertPermissionDenied(onNotRestartApp = ::goSetting, onQuitApp = ::leave ) // Appelle la fonction AlertPermissionDenied qui peut lancer la fonction launchCamera().
                }
            }

        }

    private fun goSetting()
    {
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        ).also(::startActivity)
    }
}

private fun leave()
{
    exitProcess(-1)
}
