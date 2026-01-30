package yahyr.paredes.metaltoolsprehistory.ui


import platform.UIKit.UIScreen

actual fun screenScaleFactor(): Float {
    val screenWidth = UIScreen.mainScreen.bounds.size.width.toFloat()
    return when {
        screenWidth >= 1024 -> 1.5f // iPad grande
        screenWidth >= 768 -> 1.2f  // iPad mini
        else -> 1f // iPhone
    }
}