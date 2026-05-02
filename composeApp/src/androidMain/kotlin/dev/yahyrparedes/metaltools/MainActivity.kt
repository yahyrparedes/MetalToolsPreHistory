package dev.yahyrparedes.metaltools

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import dev.yahyrparedes.metaltools.data.bronceEra
import dev.yahyrparedes.metaltools.data.cobreEra
import dev.yahyrparedes.metaltools.data.hierroEra
import dev.yahyrparedes.metaltools.data.piedraEra
import dev.yahyrparedes.metaltools.ui.AnimatedScreen
import dev.yahyrparedes.metaltools.ui.EraScreen
import dev.yahyrparedes.metaltools.ui.FinalScreen
import dev.yahyrparedes.metaltools.ui.Screen
import dev.yahyrparedes.metaltools.ui.StartScreen
import dev.yahyrparedes.metaltools.theme.PrehistoryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        setContent {

            App()
        }
    }
}

