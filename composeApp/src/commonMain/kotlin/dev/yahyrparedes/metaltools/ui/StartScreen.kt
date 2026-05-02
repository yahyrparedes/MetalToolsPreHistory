package dev.yahyrparedes.metaltools.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import metaltoolsprehistory.composeapp.generated.resources.Res
import metaltoolsprehistory.composeapp.generated.resources.bg_initial
import dev.yahyrparedes.metaltools.theme.ButtonGreen

import dev.yahyrparedes.metaltools.audio.AudioPlayer
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
@Composable
fun StartScreen(onStart: () -> Unit) {
    val audioPlayer = remember { AudioPlayer() }

    LaunchedEffect(Unit) {
        audioPlayer.play("inicio")
    }
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFEFE7D8)),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize().padding(32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Las herramientas en la prehistoria",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5D4037),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge,
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onStart,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ButtonGreen
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "Empezar",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.bg_initial),
                        contentDescription = "null",
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewStartScreen() {
    StartScreen {

    }
}