package com.example.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.presentation.R

internal val SFProDisplay = FontFamily(
    Font(R.font.sf_pro_display_medium, FontWeight.Medium),
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold)
)

internal val Title1 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 22.sp,
    fontWeight = FontWeight.SemiBold
)

internal val Title2 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 20.sp,
    fontWeight = FontWeight.SemiBold
)

internal val Title3 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium
)

internal val Title4 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 14.sp,
    fontWeight = FontWeight.Medium
)

internal val Text1 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal
)

internal val ButtonText1 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold
)

internal val ButtonText2 = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal
)

internal val TabText = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal
)

internal val Number = TextStyle(
    fontFamily = SFProDisplay,
    fontSize = 7.sp,
    fontWeight = FontWeight.Normal
)

@Immutable
internal data class CustomTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val text1: TextStyle,
    val buttonText1: TextStyle,
    val buttonText2: TextStyle,
    val tabText: TextStyle,
    val number: TextStyle
)

internal val Typography = CustomTypography(
    title1 = Title1,
    title2 = Title2,
    title3 = Title3,
    title4 = Title4,
    text1 = Text1,
    buttonText1 = ButtonText1,
    buttonText2 = ButtonText2,
    tabText = TabText,
    number = Number
)

internal val LocalTypography = staticCompositionLocalOf {
    Typography
}
