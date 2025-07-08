package com.pixel.caffeine.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CupCustomizationScreen(modifier: Modifier = Modifier) {
    Box(modifier) {
        Text(text = "CupCustomizationScreen")
    }
}

@Preview(name = "CupCustomizationScreen")
@Composable
private fun PreviewCupCustomizationScreen() {
    CupCustomizationScreen()
}
