package com.pixel.caffeine.presentation.screens.coffeePicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pixel.caffeine.R
import com.pixel.caffeine.presentation.components.AppHeader
import com.pixel.caffeine.presentation.components.ContinueButton
import com.pixel.caffeine.presentation.navigation.Screen
import com.pixel.caffeine.presentation.theme.Urbanist
import kotlin.math.absoluteValue

@Composable
fun CoffeePickerScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val coffeeCups =
        listOf(
            CoffeeCup(
                name = stringResource(R.string.latte),
                image = R.drawable.img_latte_cup,
            ),
            CoffeeCup(
                name = stringResource(R.string.macchiato),
                image = R.drawable.img_macchiato_cup,
            ),
            CoffeeCup(
                name = stringResource(R.string.black),
                image = R.drawable.img_black_cup,
            ),
            CoffeeCup(
                name = stringResource(R.string.espresso),
                image = R.drawable.img_espresso_cup,
            ),
        )

    var currentSelectedCup by remember { mutableStateOf(coffeeCups.first()) }

    CoffeePickerContent(
        coffeeCups = coffeeCups,
        onChangeSelectedCup = { currentSelectedCup = it },
        onNavigateToNextScreen = { navController.navigate(Screen.CupCustomization(currentSelectedCup)) },
        modifier = modifier,
    )
}

@Composable
private fun CoffeePickerContent(
    coffeeCups: List<CoffeeCup>,
    onChangeSelectedCup: (CoffeeCup) -> Unit,
    onNavigateToNextScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        AppHeader(modifier = Modifier.padding(horizontal = 16.dp))
        CoffeePickerHeader(
            modifier =
                Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
        )
        CoffeePickerPager(
            coffeeCups = coffeeCups,
            onChangeSelectedCup = onChangeSelectedCup,
            modifier = Modifier.weight(1f),
        )
        ContinueButton(
            onClick = onNavigateToNextScreen,
            modifier =
                Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 50.dp)
                    .align(Alignment.CenterHorizontally),
        )
    }
}

@Composable
private fun CoffeePickerPager(
    coffeeCups: List<CoffeeCup>,
    onChangeSelectedCup: (CoffeeCup) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(pageCount = { coffeeCups.size })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 80.dp),
        modifier = modifier,
    ) { currentPage ->
        val coffeeCup = coffeeCups[currentPage]

        val pageOffset = ((pagerState.currentPage - currentPage) + pagerState.currentPageOffsetFraction).absoluteValue

        CoffeeCupItem(
            name = coffeeCup.name,
            image = painterResource(coffeeCup.image),
            pageOffset = pageOffset,
        )
    }

    LaunchedEffect(pagerState.currentPage) {
        onChangeSelectedCup(coffeeCups[pagerState.currentPage])
    }
}

@Composable
private fun CoffeePickerHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Good Morning",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xFFB3B3B3),
        )
        Text(
            text = "Hamsa ☀",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xFF3B3B3B),
        )
        Text(
            text = "What would you like to drink today?",
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xFF3B3B3B),
            modifier = Modifier.padding(top = 4.dp),
        )
    }
}

@Preview(name = "CoffeePicker")
@Composable
private fun PreviewCoffeePicker() {
    Box(Modifier.background(Color.White)) { CoffeePickerScreen(rememberNavController()) }
}
