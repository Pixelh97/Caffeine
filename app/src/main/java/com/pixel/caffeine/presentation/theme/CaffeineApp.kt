package com.pixel.caffeine.presentation.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pixel.caffeine.presentation.navigation.NavGraph

@Composable
fun CaffeineApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination: NavDestination? = backStackEntry?.destination
    Scaffold(
        containerColor = Color.White,
    ) { innerPadding ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Preview(name = "CaffeineApp")
@Composable
private fun PreviewCaffeineApp() {
    CaffeineTheme { CaffeineApp() }
}
