package com.pixel.caffeine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pixel.caffeine.R
import com.pixel.caffeine.presentation.theme.Urbanist

@Composable
fun ContinueButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1F1F1F),
                contentColor = Color.White.copy(alpha = 0.87f),
            ),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        modifier =
            modifier.dropShadow(
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
            text = stringResource(R.string.tx_continue),
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.25.sp,
            fontSize = 16.sp,
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_right),
            contentDescription = stringResource(R.string.tx_continue),
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}

@Preview(name = "ContinueButton")
@Composable
private fun PreviewContinueButton() {
    Box(
        Modifier
            .background(Color.White)
            .padding(54.dp),
    ) { ContinueButton({}) }
}
