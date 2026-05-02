package dev.yahyrparedes.metaltools.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import metaltoolsprehistory.composeapp.generated.resources.Res
import metaltoolsprehistory.composeapp.generated.resources.nunito_bold
import metaltoolsprehistory.composeapp.generated.resources.nunito_regular
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.InternalResourceApi
import dev.yahyrparedes.metaltools.ui.screenScaleFactor


@OptIn(ExperimentalResourceApi::class, InternalResourceApi::class)
@Composable
fun NunitoFontFamily(): FontFamily {
    return FontFamily(
        Font(
            resource =  Res.font.nunito_regular,
//            resource = FontResource("font/nunito_regular.ttf"),
            weight = FontWeight.Normal
        ),
        Font(
            resource =  Res.font.nunito_bold,
//            resource = FontResource("font/nunito_bold.ttf"),
            weight = FontWeight.Bold
        )
    )
}

@Composable
fun AppTypography(): Typography {
    val nunito = NunitoFontFamily()
    val factor = screenScaleFactor()

    // Escalar tamaño según pantalla
    fun scaled(size: Int) = (size * factor).sp

    return Typography(
        titleLarge = TextStyle(
            fontFamily = nunito,
            fontSize = scaled(35),
            fontWeight = FontWeight.Bold
        ),
        bodyLarge = TextStyle(
            fontFamily = nunito,
            fontSize = scaled(24)
        ),
        labelLarge = TextStyle(
            fontFamily = nunito,
            fontSize = scaled(20),
            fontWeight = FontWeight.Medium
        )
    )
}

//val Typography = Typography(
//    titleLarge = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontSize = 26.sp,
//        fontWeight = FontWeight.Bold
//    ),
//    bodyLarge = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontSize = 18.sp
//    ),
//    labelLarge = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontSize = 18.sp,
//        fontWeight = FontWeight.Medium
//    )
//)
