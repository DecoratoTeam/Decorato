package com.example.decorato.presentation.theme

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.colors.darkThemeColors
import com.example.decorato.presentation.theme.colors.lightThemeColors


@SuppressLint("ContextCastToActivity")
@Composable
fun DecoratoTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val theme = if (isDarkTheme) darkThemeColors else lightThemeColors

    val activity = LocalContext.current as? Activity
    val view = LocalView.current

    if (activity != null) {
        activity.window.navigationBarColor = theme.surface.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars =
            !isDarkTheme
    }
    CompositionLocalProvider(
        LocalDecoratoAppColors provides theme,
        LocalIsDarkTheme provides isDarkTheme,
        LocalNavManager provides NavigationManager(rememberNavController())
    ) {
        content()
    }
}

val LocalIsDarkTheme =
    compositionLocalOf<Boolean> {
        error("LocalIsDarkTheme not provided")
    }
