package dev.yahyrparedes.metaltools.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

// Placeholder iOS: la resolución de assets en iOS se realiza normalmente con APIs nativas.
// Si necesitas un helper multiplataforma, implementa una función en androidMain/iosMain con el mismo nombre.
@Composable
fun painterResourceByName(name: String): Painter? {
    return null
}
