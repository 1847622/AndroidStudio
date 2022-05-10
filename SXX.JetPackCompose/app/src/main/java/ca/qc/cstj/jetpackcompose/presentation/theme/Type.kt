package ca.qc.cstj.jetpackcompose.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ca.qc.cstj.jetpackcompose.R


val alatsi = FontFamily(
    listOf(
        Font(R.font.alatsi, FontWeight.Normal),
        Font(R.font.alatsi, FontWeight.Medium),
        Font(R.font.alatsi, FontWeight.SemiBold),
        Font(R.font.alatsi, FontWeight.Bold),
        Font(R.font.alatsi, FontWeight.Black)
    )

)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = AquaBlue,
        fontFamily = alatsi,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = TextWhite,
        fontFamily = alatsi,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h2 = TextStyle(
        color = TextWhite,
        fontFamily = alatsi,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)
