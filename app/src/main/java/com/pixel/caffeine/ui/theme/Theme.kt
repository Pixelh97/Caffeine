package com.pixel.caffeine.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun CaffeineTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider {
        content()
    }
}
