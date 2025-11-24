package com.example.decorato.presentation.theme.colors

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class DecoratoAppColors(
    val primary: Color,
    val secondary: Color,
    val primaryVariant: Color,
    val titleL: Color,
    val body: Color,
    val hint: Color,
    val stroke: Color,
    val surface: Color,
    val surfaceHigh: Color,
    val onPrimary: Color,
    val onPrimaryBody: Color,
    val onPrimaryHint: Color,
    val disable: Color,
    val iconBackground: Color,
    val blurOverly: Color,
    val red: Color,
    val green: Color,
    val greenVariant: Color,
    val yellowAccent: Color,
    val blueCard: Color,
    val navyCard: Color,
    val onBoardingGradient: List<Color>,
    val greenAccent: Color,
    val successSnackBarShadow: Color,
    val redAccent: Color,
    val failureSnackBarShadow: Color,
)

internal val LocalDecoratoAppColors = staticCompositionLocalOf { lightThemeColors }
