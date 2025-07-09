package com.pixel.caffeine.presentation.navigation

import com.pixel.caffeine.presentation.screens.coffeePicker.CoffeeCup
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Home : Screen()

    @Serializable
    object CoffeePicker : Screen()

    @Serializable
    data class CupCustomization(val coffeeCup: CoffeeCup) : Screen()

    @Serializable
    object PreparingOrder : Screen()

    @Serializable
    object CoffeeReady : Screen()

    @Serializable
    object StackPicker : Screen()

    @Serializable
    object ConfirmOrder : Screen()
}
