package dev.yahyrparedes.metaltools.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = ButtonGreen,
    secondary = AccentYellow,
    background = BackgroundCream,
    surface = BackgroundCream,
    onPrimary = BackgroundCream,
    onSecondary = BackgroundCream,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun PrehistoryAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = AppTypography(),
        content = content
    )
}
