package yahyr.paredes.metaltoolsprehistory

import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import yahyr.paredes.metaltoolsprehistory.data.bronceEra
import yahyr.paredes.metaltoolsprehistory.data.cobreEra
import yahyr.paredes.metaltoolsprehistory.data.hierroEra
import yahyr.paredes.metaltoolsprehistory.data.piedraEra
import yahyr.paredes.metaltoolsprehistory.theme.PrehistoryAppTheme
import yahyr.paredes.metaltoolsprehistory.ui.AnimatedScreen
import yahyr.paredes.metaltoolsprehistory.ui.EraScreen
import yahyr.paredes.metaltoolsprehistory.ui.FinalScreen
import yahyr.paredes.metaltoolsprehistory.ui.Screen
import yahyr.paredes.metaltoolsprehistory.ui.StartScreen

@Composable
@Preview
fun App() {
    PrehistoryAppTheme {

        CompositionLocalProvider(
            LocalDensity provides Density(
                density = LocalDensity.current.density,
                fontScale = 1f
            )
        ) {
            var currentScreen by remember { mutableStateOf(Screen.START) }

            when (currentScreen) {
                Screen.START -> AnimatedScreen {
                    StartScreen {
                        currentScreen = Screen.PIEDRA
                    }
                }

                Screen.PIEDRA -> AnimatedScreen {
                    EraScreen(
                        era = piedraEra,
                        onNext = { currentScreen = Screen.COBRE }
                    )
                }

                Screen.COBRE -> AnimatedScreen {
                    EraScreen(
                        era = cobreEra,
                        onNext = { currentScreen = Screen.BRONCE }
                    )
                }

                Screen.BRONCE -> AnimatedScreen {
                    EraScreen(
                        era = bronceEra,
                        onNext = { currentScreen = Screen.HIERRO }
                    )
                }

                Screen.HIERRO -> AnimatedScreen {
                    EraScreen(
                        era = hierroEra,
                        onNext = { currentScreen = Screen.FINAL }
                    )
                }

                Screen.FINAL -> AnimatedScreen {
                    FinalScreen(finish = {
                        currentScreen = Screen.START
                    })
                }
            }
        }
    }
}