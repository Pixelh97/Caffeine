package com.pixel.caffeine.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CoffeeReadyScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "CoffeeReadyScreen")
    }
}

@Preview(name = "CoffeeReadyScreen")
@Composable
private fun PreviewCoffeeReadyScreen() {
    CoffeeReadyScreen()
}