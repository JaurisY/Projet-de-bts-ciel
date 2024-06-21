package com.example.projetstage.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.projectable.R

@Composable
fun Marge(){
    Box {
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 270.dp, x = (-100).dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 245.dp, x = (-100).dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 235.dp, x = (-100).dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 235.dp, x = 10.dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 245.dp, x = 10.dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 270.dp, x = 10.dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 270.dp, x = 100.dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 245.dp, x = 100.dp))
        Image(painter = painterResource(R.drawable.marge), contentDescription = "Marge", modifier = Modifier
            .size(1000.dp)
            .offset(y = 235.dp, x = 100.dp))
    }
}

@Composable
fun Viseur(){
    // Il y a 8 image pour assemblé le "viseur" pour scanner un QR code.
    Image(painter = painterResource(R.drawable.viseur_qrcode_hor_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (40).dp, y = (190).dp))
    Image(painter = painterResource(R.drawable.viseur_qrcode_ver_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (20).dp, y = (210).dp))
    Image(painter = painterResource(R.drawable.viseur_qrcode_hor_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (240).dp, y = (190).dp))
    Image(painter = painterResource(R.drawable.viseur_qrcode_ver_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (260).dp, y = (210).dp))
    Image(painter = painterResource(R.drawable.viseur_qrcode_hor_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (40).dp, y = (450).dp))
    Image(painter = painterResource(R.drawable.viseur_qrcode_ver_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (20).dp, y = (430).dp))
    Image(painter = painterResource(R.drawable.viseur_qrcode_hor_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (240).dp, y = (450).dp))
    Image(painter = painterResource(R.drawable.viseur_qrcode_ver_blanc), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(80.dp)
        .offset(x = (260).dp, y = (430).dp))
}

@Composable
fun MargeHideButton()
{
    Image(painter = painterResource(R.drawable.marge_hide_button), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(1000.dp)
        .offset(x = (-100).dp, y = (205).dp))
    Image(painter = painterResource(R.drawable.marge_hide_button), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(1000.dp)
        .offset(x = (10).dp, y = (205).dp))
    Image(painter = painterResource(R.drawable.marge_hide_button), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(1000.dp)
        .offset(x = (100).dp, y = (205).dp))
}

@Composable
fun SettingHideButton()
{
    Image(painter = painterResource(R.drawable.marge_hide_button), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(400.dp)
        .offset(x = (90).dp, y = (140).dp))
    Image(painter = painterResource(R.drawable.marge_hide_button), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(400.dp)
        .offset(x = (90).dp, y = (150).dp))
    Image(painter = painterResource(R.drawable.marge_hide_button), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(400.dp)
        .offset(x = (90).dp, y = (230).dp))
    Image(painter = painterResource(R.drawable.marge_hide_button), contentDescription = "Viseur Qrcode", modifier = Modifier
        .size(400.dp)
        .offset(x = (90).dp, y = (240).dp))
}
