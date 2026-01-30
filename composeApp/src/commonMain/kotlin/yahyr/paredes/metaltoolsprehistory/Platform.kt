package yahyr.paredes.metaltoolsprehistory

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform