package com.pixel.caffeine.presentation.screens.coffeePicker

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.pixel.caffeine.R
import com.pixel.caffeine.presentation.theme.Urbanist

@Composable
fun CoffeeCupItem(
    name: String,
    image: Painter,
    pageOffset: Float,
    modifier: Modifier = Modifier,
) {
    val scale = lerp(1.1f, 0.65f, pageOffset.coerceIn(0f, 1f))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier =
                Modifier
                    .scale(scale)
                    .padding(horizontal = 16.dp),
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier,
            )
            Image(
                painter = painterResource(R.drawable.img_tc_logo),
                contentDescription = null,
                modifier = Modifier.padding(top = 52.dp),
            )
        }
        Text(
            text = name,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1F1F1F),
            fontSize = 32.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier,
        )
    }
}

@Preview(name = "CoffeeCupItem")
@Composable
private fun PreviewCoffeeCupItem() {
    CoffeeCupItem(
        name = "Latte",
        image = painterResource(R.drawable.img_latte_cup),
        pageOffset = 0f,
        modifier = Modifier,
    )
}
