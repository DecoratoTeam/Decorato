package com.example.decorato.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.example.decorato.presentation.theme.colors.DecoratoAppColors
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.DecoratoTextStyle
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

typealias GradientType = @Composable () -> List<Color>

typealias ColorType = @Composable () -> Color

object AppTheme {
    val color: DecoratoAppColors
        @Composable @ReadOnlyComposable
        get() = LocalDecoratoAppColors.current

    val textStyle: DecoratoTextStyle
        @Composable @ReadOnlyComposable
        get() = LocalDecoratoTextStyle.current
}
