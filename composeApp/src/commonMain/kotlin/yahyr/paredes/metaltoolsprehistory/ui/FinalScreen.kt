package yahyr.paredes.metaltoolsprehistory.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import metaltoolsprehistory.composeapp.generated.resources.Res
import metaltoolsprehistory.composeapp.generated.resources.character
import metaltoolsprehistory.composeapp.generated.resources.tool_bronce
import metaltoolsprehistory.composeapp.generated.resources.tool_cobre
import metaltoolsprehistory.composeapp.generated.resources.tool_hierro
import metaltoolsprehistory.composeapp.generated.resources.tool_piedra
import yahyr.paredes.metaltoolsprehistory.theme.BackgroundCream
import org.jetbrains.compose.resources.painterResource
import yahyr.paredes.metaltoolsprehistory.audio.AudioPlayer

@Composable
fun FinalScreen() {
    val audioPlayer = remember { AudioPlayer() }

    LaunchedEffect(Unit) {
        audioPlayer.play("final_")
    }
    val tools = listOf(
        Triple(Res.drawable.tool_piedra, "Piedra", "audio_piedra"),
        Triple(Res.drawable.tool_cobre, "Cobre", "audio_cobre"),
        Triple(Res.drawable.tool_bronce, "Bronce", "audio_bronce"),
        Triple(Res.drawable.tool_hierro, "Hierro", "audio_hierro")
    )

    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundCream)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Las herramientas fueron mejorando",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(modifier = Modifier.height(32.dp))

            //hagamos na logica

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                tools.forEachIndexed { index, tool ->
                    val isSelected = selectedIndex == index
                    val scale by animateFloatAsState(
                        targetValue = if (isSelected) 1.2f else 1f,
                        label = ""
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            selectedIndex = index
                            audioPlayer.play(tool.third)
                        }
                    ) {
                        Image(
                            painter = painterResource(tool.first),
                            contentDescription = tool.second,
                            modifier = Modifier
                                .size(120.dp)
                                .graphicsLayer {
                                    scaleX = scale
                                    scaleY = scale
                                }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = tool.second,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            Box {
                Image(
                    painter = painterResource(Res.drawable.character),
                    contentDescription = null,
                    modifier = Modifier.clickable {
//                    (context as? Activity)?.recreate()
                    }
                )
            }
        }
    }
}