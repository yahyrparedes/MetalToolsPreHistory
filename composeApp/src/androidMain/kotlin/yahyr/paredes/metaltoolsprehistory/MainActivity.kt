package yahyr.paredes.metaltoolsprehistory

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
import yahyr.paredes.metaltoolsprehistory.data.bronceEra
import yahyr.paredes.metaltoolsprehistory.data.cobreEra
import yahyr.paredes.metaltoolsprehistory.data.hierroEra
import yahyr.paredes.metaltoolsprehistory.data.piedraEra
import yahyr.paredes.metaltoolsprehistory.ui.AnimatedScreen
import yahyr.paredes.metaltoolsprehistory.ui.EraScreen
import yahyr.paredes.metaltoolsprehistory.ui.FinalScreen
import yahyr.paredes.metaltoolsprehistory.ui.Screen
import yahyr.paredes.metaltoolsprehistory.ui.StartScreen
import yahyr.paredes.metaltoolsprehistory.theme.PrehistoryAppTheme

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
