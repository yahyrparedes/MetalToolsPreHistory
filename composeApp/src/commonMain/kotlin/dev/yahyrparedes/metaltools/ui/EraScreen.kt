package dev.yahyrparedes.metaltools.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yahyrparedes.metaltools.audio.AudioPlayer
import dev.yahyrparedes.metaltools.data.Era
import dev.yahyrparedes.metaltools.theme.ButtonGreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun EraScreen(
    era: Era,
    onNext: () -> Unit
) {

    val audioPlayer = remember { AudioPlayer() }

    var animate by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (animate) 1.1f else 1f,
        label = ""
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource( era.backgroundRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = era.title,
                fontSize = 46.sp,
                color = Color(0XFF5D4037),
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(era.toolRes),
                contentDescription = "title",
                modifier = Modifier
                    .size(260.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
                    .clickable {
                        animate = true
                        audioPlayer.play(era.sound)
                    }
            )

            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonGreen
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Siguiente",
                    color = Color.White,
                    fontSize = 34.sp
                )

            }
        }
    }
}
