package com.example.decorato.presentation.theme.colors

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class DecoratoAppColors(
    val surface: Color,
)

internal val LocalDecoratoAppColors = staticCompositionLocalOf { lightThemeColors }
