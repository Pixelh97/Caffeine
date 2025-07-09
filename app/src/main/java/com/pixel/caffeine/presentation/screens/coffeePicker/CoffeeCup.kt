package com.pixel.caffeine.presentation.screens.coffeePicker

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class CoffeeCup(
    val name: String,
    @DrawableRes val image: Int,
)
