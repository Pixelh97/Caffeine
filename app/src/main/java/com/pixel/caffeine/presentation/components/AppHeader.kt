package com.pixel.caffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.pixel.caffeine.R
import com.pixel.caffeine.presentation.theme.whiteSmoke

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
            modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = stringResource(R.string.profile_image),
            modifier =
                Modifier
                    .clip(CircleShape)
                    .size(48.dp),
        )

        IconButton(
            onClick = { /*TODO*/ },
            colors =
                IconButtonDefaults
                    .iconButtonColors(
                        containerColor = whiteSmoke,
                        contentColor = Color(0xde1f1f1f),
                    ),
            modifier = Modifier.size(48.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                contentDescription = stringResource(R.string.add_button),
            )
        }
    }
}
