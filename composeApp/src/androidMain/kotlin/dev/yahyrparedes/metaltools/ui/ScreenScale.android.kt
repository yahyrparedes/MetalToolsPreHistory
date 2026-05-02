package dev.yahyrparedes.metaltools.ui


import android.content.res.Configuration
import dev.yahyrparedes.metaltools.appContext

actual fun screenScaleFactor(): Float {
    val screenWidthDp = appContext.resources.configuration.screenWidthDp
    return when {
        screenWidthDp >= 720 -> 1.5f // tablet grande
        screenWidthDp >= 480 -> 1.2f // tablet pequeña / phablet
        else -> 0.85f // celular
    }
}