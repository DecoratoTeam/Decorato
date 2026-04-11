package com.example.decorato.presentation.theme

import android.app.Activity
import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.view.WindowCompat
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.colors.darkThemeColors
import com.example.decorato.presentation.theme.colors.lightThemeColors

// 1. الزيتونة: انقليه هنا فوق عشان الكل يشوفه
val LocalIsDarkTheme = compositionLocalOf<Boolean> {
    error("LocalIsDarkTheme not provided")
}

@SuppressLint("ContextCastToActivity")
@Composable
fun DecoratoTheme(
    isDarkTheme: Boolean = false,
    language: AppLanguage = AppLanguage.ENGLISH,
    content: @Composable () -> Unit,
) {
    val theme = if (isDarkTheme) darkThemeColors else lightThemeColors

    // 2. ضبط اتجاه الشاشة
    val direction = if (language == AppLanguage.ARABIC) {
        LayoutDirection.Rtl
    } else {
        LayoutDirection.Ltr
    }

    val activity = LocalContext.current as? Activity
    val view = LocalView.current

    if (activity != null) {
        // "الزيتونة": استخدمنا surface بدل background عشان ده المسمى اللي في ملف الألوان بتاعكم
        activity.window.statusBarColor = theme.surface.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars = !isDarkTheme
    }

    CompositionLocalProvider(
        LocalDecoratoAppColors provides theme,
        LocalIsDarkTheme provides isDarkTheme,
        LocalLayoutDirection provides direction // دي اللي هتشغل العربي يمين والانجليزي شمال
    ) {
        content()
    }
}