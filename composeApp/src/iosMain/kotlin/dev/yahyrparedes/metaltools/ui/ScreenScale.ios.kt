package dev.yahyrparedes.metaltools.ui


import platform.UIKit.UIScreen
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import kotlin.OptIn

@OptIn(ExperimentalForeignApi::class)
actual fun screenScaleFactor(): Float {
    val screenWidth = UIScreen.mainScreen.nativeBounds.useContents { size.width.toFloat() }
    return when {
        screenWidth >= 1024 -> 1.5f // iPad grande
        screenWidth >= 768 -> 1.2f  // iPad mini
        else -> 0.85f // iPhone
    }
}