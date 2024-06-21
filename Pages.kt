package com.example.projetstage.composables

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.projectable.R
import kotlin.system.exitProcess
// /_> composables

@Composable
fun App() {
    val appSwitch: MutableState<Int> = remember { // Définit une variable de type Boolean qui grace à l'action remember va s'en souvenir.
        mutableIntStateOf(1)

        // 1 = Accueil
        // 2 = Détails
        // 3 = Paramètres
        // 4 = Caméra
        // 5 = Quitter
        // 6 = Quitter depuis Accueil
        // 7 = Quitter depuis Détails
        // 8 = Quitter depuis Paramètres

    }
    when { // similaire à un if
        (appSwitch.value == 1) -> { // Si cameraSwitch a pour valeur 1.
            Box(modifier = Modifier.fillMaxSize()) {
                Home(onCamera = { appSwitch.value = 4 }) // Appelle la fonction ButtonImage() qui peut changer la valeur de cameraSwitch.
                Marge()
                DetailsButton (onDetails = { appSwitch.value = 2 })
                SettingsButton (onHistory = { appSwitch.value = 3 })
                LeaveButton (onLeave = { appSwitch.value = 6 })
                MargeHideButton()
            }
        }

        (appSwitch.value == 2) -> { // Si cameraSwitch a pour valeur 2.
            Box { // Superpose les éléments.
                Details(onCamera = { appSwitch.value = 4 }) // Si cameraSwitch a pour valeur 3.
                Marge()
                BackButton (onBack = { appSwitch.value = 1 })
                LeaveButton(onLeave = { appSwitch.value = 7 })
                MargeHideButton()
            }

        }

        (appSwitch.value == 3) -> {
             Box {
                 SettingsApp()
             }
        }

        (appSwitch.value == 4) ->{
            Box{
                QRcodeScreen() // Appelle la fonction QRcodeScreen() qui permet d'utiliser la caméra et le scanner.QRcodeScreen()
                Viseur() // Appelle la fonction Viseur() qui permet de mettre en place un viseur pour scanner.
                LeaveButton (onLeave = { appSwitch.value = 5 })
            }
        }

        (appSwitch.value == 5) -> {
            Leave()
        }

        (appSwitch.value == 6) -> {
            AlertLeave(onLeave = { appSwitch.value = 5 }, onNotLeave = { appSwitch.value = 1 })
        }

        (appSwitch.value == 7) -> {
            AlertLeave(onLeave = { appSwitch.value = 5 }, onNotLeave = { appSwitch.value = 2 })
        }

        (appSwitch.value == 8) -> {
            AlertLeave(onLeave = { appSwitch.value = 5 }, onNotLeave = { appSwitch.value = 3 })
        }

        (appSwitch.value == 9) -> {
            AlertLeave(onLeave = { appSwitch.value = 5 }, onNotLeave = { appSwitch.value = 4 })
        }
    }
}

@Composable
fun Home(onCamera: () -> Unit) {
    val imageModifier = Modifier
        .size(370.dp)
        .offset(y = (-50).dp)
    val buttonCameraModifier = Modifier.size(100.dp)
    val iconCameraModifier = Modifier
        .size(60.dp)
        .offset(y = 18.dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image( // Action qui rajoute une image.
            painter = painterResource(R.drawable.logo), // Ajoute une image.
            contentDescription = "logo", // Description non voyant
            modifier = imageModifier // Mise en page de l'image.
        )
        Spacer(modifier = Modifier.height((1).dp)) // Permet de mettre un espace.
        Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) // Action qui dispose les éléments horizontalement.
        {
            Image(
                painter = painterResource(R.drawable.camera),
                contentDescription = "icon camera", //Description non voyant
                modifier = iconCameraModifier
            )
            Button(
                onClick = onCamera,
                modifier = buttonCameraModifier
            ) { // Pour mettre un boutton.
                Text(stringResource(R.string.camera)) // Pour mettre un text qui vient des ressources strings.
            }
        }
    }
}

@Composable
fun Details(onCamera: () -> Unit) {
    val textModifier = Modifier
        .size(150.dp)
        .offset(y = 40.dp)
    val buttonCameraModifier = Modifier
        .size(100.dp)
        .offset(y = 20.dp)
    val iconCameraModifier = Modifier
        .size(60.dp)
        .offset(y = 38.dp)
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            stringResource(R.string.textDetailsIntro),
            modifier = textModifier.offset(y = (-50).dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height((1).dp)) // Permet de mettre un espace.
        Text(
            stringResource(R.string.textDetailsApp),
            modifier = textModifier.offset(y = (-40).dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height((30).dp))
        Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) // Action qui dispose les éléments horizontalement.
        {
            Image(
                painter = painterResource(R.drawable.camera), //Ajoute une image.
                contentDescription = "Icon camera",
                modifier = iconCameraModifier
            )
            Button(onClick = onCamera, modifier = buttonCameraModifier) { // Pour mettre un boutton.
                Text(stringResource(R.string.camera)) // Pour mettre un text qui vient des ressources strings.
            }
        }
    }
}

@Composable
fun SettingsApp()
{
    val context = LocalContext.current
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", context.packageName, null)
    )
    context.startActivity(intent)
}

@Composable
fun Leave()
{
    exitProcess(-1)
}
