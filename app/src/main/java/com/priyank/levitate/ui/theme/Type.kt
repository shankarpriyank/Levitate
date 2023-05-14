package com.priyank.levitate.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.priyank.levitate.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)
/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/

val Lato = FontFamily(
    Font(R.font.lato_regular)
)

val LatoLightItalic = FontFamily(
    Font(R.font.lato_light)
)
val LatoThin = FontFamily(
    Font(R.font.lato_thin)
)
val FuturaHeavy = FontFamily(
    Font(R.font.futura_heavy)
)
val FuturaLight = FontFamily(
    Font(R.font.futura_light)
)
val FuturaMedium = FontFamily(
    Font(R.font.futura_medium_bt)
)
