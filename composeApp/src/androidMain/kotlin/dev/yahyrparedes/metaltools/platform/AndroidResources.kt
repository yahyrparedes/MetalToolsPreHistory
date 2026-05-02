package dev.yahyrparedes.metaltools.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

/**
 * Devuelve un Painter asociado al recurso drawable por nombre o null si no existe.
 * Uso desde Android-only composables.
 */
@Composable
fun painterResourceByName(name: String): Painter? {
    val context = LocalContext.current
    val resId = remember(name) {
        context.resources.getIdentifier(name, "drawable", context.packageName)
    }
    return if (resId != 0) {
        painterResource(id = resId)
    } else {
        null
    }
}
