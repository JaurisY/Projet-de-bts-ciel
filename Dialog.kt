package com.example.projetstage.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.projectable.R
// /_> composables

@Composable
fun AlertPermissionDenied(onNotRestartApp: () -> Unit, onQuitApp: () -> Unit) {
    val alertModifier = Modifier
        .fillMaxSize() // Pour utilisé toute la place disponible.
        .wrapContentSize(Alignment.Center) // Pour afficher au centre
    val cardModifier = Modifier
        .fillMaxWidth() // Pour la taille.
        .height(200.dp) // Pour la position.
        .padding(16.dp) // Pour la position.
    val buttonLeaveModifier = Modifier
        .offset(x = (19).dp, y = 138.dp)
    val buttonModifier = Modifier
        .offset(x = 215.dp, y = 138.dp)

    Dialog(onDismissRequest = {}) // Permet d'afficher un pop-up.
    {
        Card(
            modifier = cardModifier,
            shape = RoundedCornerShape(16.dp)
        ) // Pour mettre un bloc pour afficher le pop-up.
        {
            Text(
                stringResource(R.string.alertPermission),
                modifier = alertModifier
            ) // Ajoute le texte alertPermission contenue dans les strings.
        }
        TextButton(onClick = onNotRestartApp, modifier = buttonModifier) {
            Text(stringResource(R.string.permissionButton))
        }
        TextButton(onClick = onQuitApp, modifier = buttonLeaveModifier) {
            Text(stringResource(R.string.Leave))
        }
    }
}

@Composable
fun AlertPermissionAccept(onRestartApp: () -> Unit = {}) {
    val alertModifier = Modifier
        .fillMaxSize() // Pour la taille.
        .wrapContentSize(Alignment.Center) // Pour la position.
    val cardModifier = Modifier
        .fillMaxWidth() // Pour la position.
        .height(200.dp) // Pour la position.
        .padding(16.dp) // Pour la position.
    val buttonModifier = Modifier
        .offset(x = 215.dp, y = 138.dp)

    Dialog(onDismissRequest = {})
    {
        Card(
            modifier = cardModifier,
            shape = RoundedCornerShape(16.dp)
        ) // Permet d'afficher un pop-up.
        {
            Text(
                stringResource(R.string.alertPermissionAccept),
                modifier = alertModifier
            ) // Ajoute le texte alertPermissionAccept contenue dans les strings.
        }
        TextButton(
            onClick = onRestartApp,
            modifier = buttonModifier
        ) {//Ajoute un boutton qui appelle la fonction on RestartApp.
            Text(stringResource(R.string.permissionButton)) //Ajoute le texte permissionButton pour mettre sur le boutton.
        }
    }
}

@Composable
fun AlertQRcode(onQRcode: () -> Unit) {
    val alertModifier = Modifier
        .fillMaxSize() // Pour utilisé toute la place disponible.
        .wrapContentSize(Alignment.Center) // Pour afficher au centre
    val cardModifier = Modifier
        .fillMaxWidth() // Pour la taille.
        .height(200.dp) // Pour la position.
        .padding(16.dp) // Pour la position.
    val buttonModifier = Modifier.offset(x = 215.dp, y = 138.dp)
    Dialog(onDismissRequest = {}) // Permet d'afficher un pop-up.
    {
        Card( // Pour mettre un bloc pour afficher le pop-up.
            modifier = cardModifier,
            shape = RoundedCornerShape(16.dp)
        )
        {
            Text(
                stringResource(R.string.alertQRcode), // Ajoute un texte contenue dans les strings.
                modifier = alertModifier
            )
        }
        TextButton(onClick = onQRcode, modifier = buttonModifier) { // Ajoute un boutton
            Text(stringResource(R.string.permissionButton)) // Ajoute un text pour mettre sur le boutton.
        }
    }
}


@Composable
fun AlertLeave(onLeave: () -> Unit, onNotLeave: () -> Unit) {
    val alertModifier = Modifier
        .fillMaxSize() // Pour utilisé toute la place disponible.
        .wrapContentSize(Alignment.Center) // Pour afficher au centre
    val cardModifier = Modifier
        .fillMaxWidth() // Pour la taille.
        .height(200.dp) // Pour la position.
        .padding(16.dp) // Pour la position.
    val buttonLeaveModifier = Modifier
        .offset(x = 234.dp, y = 138.dp)
    val buttonBackModifier = Modifier
        .offset(x = 18.dp, y = 138.dp)
    Dialog(onDismissRequest = {}) // Permet d'afficher un pop-up.
    {
        Card( // Pour mettre un bloc pour afficher le pop-up.
            modifier = cardModifier,
            shape = RoundedCornerShape(16.dp))
        {
            Text(
                stringResource(R.string.LeaveConfirm), // Ajoute un texte contenue dans les strings.
                modifier = alertModifier) }
        TextButton(onClick = onLeave, modifier = buttonLeaveModifier) { // Ajoute un boutton
            Text(stringResource(R.string.Leave)) // Ajoute un text pour mettre sur le boutton.
        }
        TextButton(onClick = onNotLeave, modifier = buttonBackModifier) { // Ajoute un boutton
            Text(stringResource(R.string.back)) // Ajoute un text pour mettre sur le boutton.
        }
    }
}
