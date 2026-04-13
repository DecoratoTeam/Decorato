package com.example.decorato.presentation.theme.colors

import androidx.compose.ui.graphics.Color

internal val darkThemeColors = DecoratoAppColors(
    primary = Color(0xFF00B386),
    secondary = Color(0xFFCCFFF2),
    primaryVariant = Color(0xFF1B453B),

    titleL = Color(0xFFD3D6D5).copy(alpha = 0.38f), // Title 38%
    body = Color(0xFFE0E0E0).copy(alpha = 0.60f),  // Body 60%
    hint = Color(0xFFE0E0E0).copy(alpha = 0.38f),  // Hint 38%
    stroke = Color(0xFFE0E0E0).copy(alpha = 0.08f), // Stroke 8%

    surface = Color(0xFF171717),
    surfaceHigh = Color(0xFF0D0D0D),

    onPrimary = Color(0xFF0D0D0D).copy(alpha = 0.87f),
    onPrimaryBody = Color(0xFF0D0D0D).copy(alpha = 0.50f),
    onPrimaryHint = Color(0xFFFFFFFF).copy(alpha = 0.08f),

    disable = Color(0xFF272727),
    blurOverly = Color(0xFF111111),

    red = Color(0xFFEF4444),
    redAccent = Color(0xFFF15B5B),
    redVariant = Color(0xFFFBEEEE),
    green = Color(0xFF67C2AC),
    greenVariant = Color(0xFF1B453B).copy(alpha = 0.31f), // Green variant 31%
    greenAccent = Color(0xFF4CB351),
    yellowAccent = Color(0xFFFCB84B),

    iconBackground = Color(0xB30D090B),
    blueCard = Color(0x3D8DD3F2),
    navyCard = Color(0x3D91A9FA),
    onBoardingGradient = listOf(Color(0xFF0D0D0D), Color(0xFF171717)),
    successSnackBarShadow = Color(0x1F4CB351),
    failureSnackBarShadow = Color(0x1FF15B5B),
    primaryEnd = Color(0xFF973A66),
    googleText = Color(0xFF44A148)
)