package dev.yahyrparedes.metaltools.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedScreen(
    content: @Composable () -> Unit
) {
    val alpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(
            durationMillis = 600,
            easing = FastOutSlowInEasing
        ),
        label = ""
    )

    val offsetY by animateDpAsState(
        targetValue = 0.dp,
        animationSpec = tween(
            durationMillis = 600,
            easing = FastOutSlowInEasing
        ),
        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                this.alpha = alpha
                translationY = offsetY.toPx()
            }
    ) {
        content()
    }
}