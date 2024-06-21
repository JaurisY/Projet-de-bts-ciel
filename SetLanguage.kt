package com.example.projetstage.composables

import androidx.compose.runtime.Composable
import java.util.Locale

@Composable
fun SetLanguage(language: Int)
{
    val local = Locale(
        when (language){
            0 -> "fr"
            1 -> "en"
            else -> { "fr" }
        }
    )


}


