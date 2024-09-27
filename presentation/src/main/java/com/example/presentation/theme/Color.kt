package com.example.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
internal data class ColorScheme(
    val black: Color,
    val grey1: Color,
    val grey2: Color,
    val grey3: Color,
    val grey4: Color,
    val grey5: Color,
    val white: Color,
    val blue: Color,
    val darkBlue: Color,
    val green: Color,
    val darkGreen: Color,
    val red: Color,
    val shadows: Color
)

internal val Colors = ColorScheme(
    black = Color(0xFF000000),
    grey1 = Color(0xFF222325),
    grey2 = Color(0xFF313234),
    grey3 = Color(0xFF858688),
    grey4 = Color(0xFF9F9F9F),
    grey5 = Color(0xFFDBDBDB),
    white = Color(0xFFFFFFFF),
    blue = Color(0xFF2B7EFE),
    darkBlue = Color(0xFF00427D),
    green = Color(0xFF4CB24E),
    darkGreen = Color(0xFF015905),
    red = Color(0xFFFF0000),
    shadows = Color(0x0C0C0CE5),
)

internal val LocalColorScheme = staticCompositionLocalOf {
    Colors
}
