package com.pixel.caffeine.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pixel.caffeine.presentation.screens.CoffeeReadyScreen
import com.pixel.caffeine.presentation.screens.ConfirmOrderScreen
import com.pixel.caffeine.presentation.screens.CupCustomizationScreen
import com.pixel.caffeine.presentation.screens.HomeScreen
import com.pixel.caffeine.presentation.screens.PreparingOrderScreen
import com.pixel.caffeine.presentation.screens.StackPickerScreen
import com.pixel.caffeine.presentation.screens.coffeePicker.CoffeePickerScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = Screen.Home) {
        composable<Screen.Home> {
            HomeScreen(navController = navController, modifier = modifier)
        }
        composable<Screen.CoffeePicker> {
            CoffeePickerScreen(navController = navController, modifier = modifier)
        }
        composable<Screen.CupCustomization> {
            CupCustomizationScreen(modifier = modifier)
        }
        composable<Screen.PreparingOrder> {
            PreparingOrderScreen(modifier = modifier)
        }
        composable<Screen.CoffeeReady> {
            CoffeeReadyScreen(modifier = modifier)
        }
        composable<Screen.StackPicker> {
            StackPickerScreen(modifier = modifier)
        }
        composable<Screen.ConfirmOrder> {
            ConfirmOrderScreen(modifier = modifier)
        }
    }
}
