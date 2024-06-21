package com.example.projetstage.composables

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.projectable.R

@Composable
fun BackButton(onBack: () -> Unit)
{
    val buttonModifier = Modifier
        .size(80.dp)
        .offset(x = (6).dp, y = 730.dp)
    TextButton(
        onClick = onBack,
        modifier = buttonModifier
    ) {
        Text(text = stringResource(R.string.back), color = (Color.White)) // Pour mettre un text qui vient des ressources strings.
    }
}

@Composable
fun DetailsButton(onDetails: () -> Unit)
{
    val buttonDetailsModifier = Modifier
        .size(80.dp)
        .offset(x = (6).dp, y = 730.dp)
    TextButton(
        onClick = onDetails,
        modifier = buttonDetailsModifier)
    {
        Text(text = stringResource(R.string.Details), color = (Color.White))
    }
}

@Composable
fun SettingsButton(onHistory: () -> Unit)
{
    val buttonDetailsModifier = Modifier
        .size(100.dp)
        .offset(x = (80).dp, y = 720.dp)
    TextButton(
        onClick = onHistory,
        modifier = buttonDetailsModifier
    ) {
        Text(text = stringResource(R.string.Settings), color = (Color.White))
    }
}

@Composable
fun LeaveButton(onLeave: () -> Unit)
{
    val buttonDetailsModifier = Modifier
        .size(90.dp)
        .offset(x = (271).dp, y = 725.dp)
    TextButton(
        onClick = onLeave,
        modifier = buttonDetailsModifier
    ) {
        Text(text = stringResource(R.string.Leave), color = (Color.White))
    }
}

@Composable
fun GoToSettingButton(onGoToSetting: () -> Unit )
{
    val modifierButtonGoToSetting = Modifier.size(112.dp).offset(x = 13.dp, y = (-15).dp)
    OutlinedButton(onClick = onGoToSetting, modifier = modifierButtonGoToSetting ) {
        Text(text = stringResource(R.string.permissionButton))
    }
}
