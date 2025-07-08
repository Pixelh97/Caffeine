package com.pixel.caffeine.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StackPickerScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "StackPickerScreen")
    }
}

@Preview(name = "StackPickerScreen")
@Composable
private fun PreviewStackPickerScreen() {
    StackPickerScreen()
}