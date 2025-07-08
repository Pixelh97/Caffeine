package com.pixel.caffeine.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Home : Screen()

    @Serializable
    object CoffeePicker : Screen()

    @Serializable
    object CupCustomization : Screen()

    @Serializable
    object PreparingOrder : Screen()

    @Serializable
    object CoffeeReady : Screen()

    @Serializable
    object StackPicker : Screen()

    @Serializable
    object ConfirmOrder : Screen()
}
