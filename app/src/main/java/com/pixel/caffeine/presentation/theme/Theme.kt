package com.pixel.caffeine.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun CaffeineTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider {
        content()
    }
}
