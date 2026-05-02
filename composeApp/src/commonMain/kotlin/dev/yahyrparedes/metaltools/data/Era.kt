package dev.yahyrparedes.metaltools.data

import metaltoolsprehistory.composeapp.generated.resources.Res
import metaltoolsprehistory.composeapp.generated.resources.bg_bronce
import metaltoolsprehistory.composeapp.generated.resources.bg_cobre
import metaltoolsprehistory.composeapp.generated.resources.bg_hierro
import metaltoolsprehistory.composeapp.generated.resources.bg_piedra
import metaltoolsprehistory.composeapp.generated.resources.tool_bronce
import metaltoolsprehistory.composeapp.generated.resources.tool_cobre
import metaltoolsprehistory.composeapp.generated.resources.tool_hierro
import metaltoolsprehistory.composeapp.generated.resources.tool_piedra
import org.jetbrains.compose.resources.DrawableResource


data class Era(
    val title: String,
    val backgroundRes: DrawableResource,
    val toolRes: DrawableResource,
    val sound: String
)


val piedraEra = Era(
    title = "Edad de Piedra",
    backgroundRes = Res.drawable.bg_piedra,
    toolRes = Res.drawable.tool_piedra,
    sound = "success"
)


val cobreEra = Era(
    title = "Edad del Cobre",
    backgroundRes = Res.drawable.bg_cobre,
    toolRes = Res.drawable.tool_cobre,
    sound = "success"
)

val bronceEra = Era(
    title = "Edad del Bronce",
    backgroundRes = Res.drawable.bg_bronce,
    toolRes = Res.drawable.tool_bronce,
    sound = "success"
)

val hierroEra = Era(
    title = "Edad del Hierro",
    backgroundRes = Res.drawable.bg_hierro,
    toolRes = Res.drawable.tool_hierro,
    sound = "success"
)