package dev.yahyrparedes.metaltools

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform