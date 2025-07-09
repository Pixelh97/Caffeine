package com.pixel.caffeine.presentation.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pixel.caffeine.R
import com.pixel.caffeine.presentation.components.AppHeader
import com.pixel.caffeine.presentation.navigation.Screen
import com.pixel.caffeine.presentation.theme.Sniglet
import com.pixel.caffeine.presentation.theme.Urbanist

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val animatedGhostOffset by
        rememberInfiniteTransition(label = "animatedOffset")
            .animateFloat(
                initialValue = 12f,
                targetValue = -8f,
                animationSpec =
                    InfiniteRepeatableSpec(
                        animation = tween(durationMillis = 1000),
                        repeatMode = RepeatMode.Reverse,
                    ),
            )
    val animatedDp by
        rememberInfiniteTransition(label = "animatedDp")
            .animateFloat(
                initialValue = 6f,
                targetValue = 12f,
                animationSpec =
                    InfiniteRepeatableSpec(
                        animation = tween(durationMillis = 1000),
                        repeatMode = RepeatMode.Reverse,
                    ),
            )
    val animatedShadowAlpha by
        rememberInfiniteTransition(label = "animatedShadowAlpha")
            .animateFloat(
                initialValue = 0.14f,
                targetValue = 0.08f,
                animationSpec =
                    InfiniteRepeatableSpec(
                        animation = tween(durationMillis = 1000),
                        repeatMode = RepeatMode.Reverse,
                    ),
            )

    val animatedAlpha by
        rememberInfiniteTransition(label = "animatedAlpha")
            .animateFloat(
                initialValue = 1f,
                targetValue = 0.12f,
                animationSpec =
                    InfiniteRepeatableSpec(
                        animation = tween(durationMillis = 800),
                        repeatMode = RepeatMode.Reverse,
                    ),
            )

    HomeContent(
        animatedGhostOffset = animatedGhostOffset,
        animatedDp = animatedDp,
        animatedShadowAlpha = animatedShadowAlpha,
        animatedAlpha = animatedAlpha,
        onNavigateToCoffeePicker = { navController.navigate(Screen.CoffeePicker) },
        modifier =
        modifier,
    )
}

@Composable
private fun HomeContent(
    animatedGhostOffset: Float,
    animatedDp: Float,
    animatedShadowAlpha: Float,
    animatedAlpha: Float,
    onNavigateToCoffeePicker: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
    ) {
        AppHeader()
        WelcomeMessage(
            animatedAlpha = animatedAlpha,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        AnimatedCoffeeGhost(
            animatedGhostOffset = animatedGhostOffset,
            animatedDp = animatedDp,
            animatedShadowAlpha = animatedShadowAlpha,
            modifier =
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
        )
        Button(
            onClick = onNavigateToCoffeePicker,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F1F1F)),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
            modifier =
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 50.dp)
                    .dropShadow(
                        shape = ButtonDefaults.shape,
                        shadow =
                            Shadow(
                                radius = 12.dp,
                                offset = DpOffset(0.dp, 6.dp),
                                color = Color.Black.copy(alpha = 0.24f),
                            ),
                    ),
        ) {
            Text(
                text = stringResource(R.string.bring_my_coffee),
                color = Color.White.copy(alpha = 0.87f),
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_coffee_cup),
                contentDescription = stringResource(R.string.bring_my_coffee),
                tint = Color.White.copy(alpha = 0.87f),
                modifier = Modifier.padding(start = 8.dp),
            )
        }
    }
}

@Composable
private fun AnimatedCoffeeGhost(
    animatedGhostOffset: Float,
    animatedDp: Float,
    animatedShadowAlpha: Float,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(animatedDp.dp),
        modifier =
            modifier
                .wrapContentWidth()
                .padding(top = 33.dp)
                .animateContentSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_caffeine_ghost),
            contentDescription = stringResource(R.string.coffee_ghost),
            contentScale = ContentScale.Fit,
            modifier =
                Modifier
                    .size(244.dp)
                    .offset(y = animatedGhostOffset.dp),
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.shadow_ghost),
            contentDescription = stringResource(R.string.coffee_ghost),
            modifier =
                Modifier
                    .blur(
                        radius = 12.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded,
                    ).alpha(animatedShadowAlpha),
        )
    }
}

@Composable
private fun WelcomeMessage(
    animatedAlpha: Float,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
            modifier
                .wrapContentWidth()
                .padding(top = 24.dp),
    ) {
        AnimatedStar(
            animatedAlpha = animatedAlpha,
            modifier = Modifier.align(Alignment.TopEnd),
        )
        AnimatedStar(
            animatedAlpha = animatedAlpha,
            modifier =
                Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 10.dp, bottom = 50.dp),
        )
        AnimatedStar(
            animatedAlpha = animatedAlpha,
            modifier = Modifier.align(Alignment.BottomEnd),
        )
        Text(
            text = stringResource(R.string.welcome_message),
            color = Color(0xde1f1f1f),
            fontFamily = Sniglet,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 50.sp,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun AnimatedStar(
    animatedAlpha: Float,
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_star),
        contentDescription = stringResource(R.string.star),
        tint = Color.Black.copy(alpha = animatedAlpha),
        modifier = modifier.size(16.dp),
    )
}

@Preview(name = "HomeScreen")
@Composable
private fun PreviewHomeScreen() {
    Box(modifier = Modifier.background(Color.White)) {
        HomeScreen(
            navController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}
