package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageRenderer(imageBitmap: DrawableResource, modifier: Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(50))
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(50)
                )
        )
        Image(
            painter = painterResource(imageBitmap),
            contentDescription = null,
            modifier = Modifier.background(
                color = Color(0xffCE5A01).copy(alpha = 0.2f),
                shape = CircleShape,
            ).aspectRatio(1f)
        )
    }
}