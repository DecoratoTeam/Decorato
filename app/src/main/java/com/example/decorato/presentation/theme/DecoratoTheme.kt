//package com.example.decorato.presentation.theme
//
//import android.R.attr.layoutDirection
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.util.LayoutDirection
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.CompositionLocalProvider
//import androidx.compose.runtime.compositionLocalOf
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalLayoutDirection
//import androidx.compose.ui.platform.LocalView
//import androidx.compose.ui.text.intl.Locale
//import androidx.core.view.WindowCompat
//import androidx.navigation.compose.rememberNavController
//import com.example.decorato.domain.model.AppLanguage
//import com.example.decorato.presentation.navigation.NavigationManager
//import com.example.decorato.presentation.application.LocalNavManager
//import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
//import com.example.decorato.presentation.theme.colors.darkThemeColors
//import com.example.decorato.presentation.theme.colors.lightThemeColors
//
//
//@SuppressLint("ContextCastToActivity")
//@Composable
//fun DecoratoTheme(
//    isDarkTheme: Boolean = isSystemInDarkTheme(),
//    language: AppLanguage = AppLanguage.ENGLISH,
//    content: @Composable () -> Unit,
//) {
//    val theme = if (isDarkTheme) darkThemeColors else lightThemeColors
//
//    // الزيتونة: تحديد اتجاه الشاشة بناءً على اللغة
//    val layoutDirection = if (language == AppLanguage.ARABIC) {
//        androidx.compose.ui.unit.LayoutDirection.Rtl
//    } else {
//        androidx.compose.ui.unit.LayoutDirection.Ltr
//    }
//
//    val activity = LocalContext.current as? Activity
//    val view = LocalView.current
//
//    if (activity != null) {
//        activity.window.navigationBarColor = theme.blurOverly.toArgb()
//        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars =
//            !isDarkTheme
//    }
//
//    CompositionLocalProvider(
//        LocalDecoratoAppColors provides theme,
//        LocalIsDarkTheme provides isDarkTheme,
//        LocalNavManager provides NavigationManager(rememberNavController())
//    ) {
//        content()
//    }
//}
//
//
//
//val LocalIsDarkTheme =
//    compositionLocalOf<Boolean> {
//        error("LocalIsDarkTheme not provided")
//    }
//
//
//

package com.example.decorato.presentation.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration // ✅ Import الصح
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.colors.darkThemeColors
import com.example.decorato.presentation.theme.colors.lightThemeColors
import java.util.Locale

@SuppressLint("ContextCastToActivity")
@Composable
fun DecoratoTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    language: AppLanguage = AppLanguage.ENGLISH,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    // 1. الزيتونة: استخدام LocalConfiguration بدلاً من context.resources
    val currentConfig = LocalConfiguration.current
    val theme = if (isDarkTheme) darkThemeColors else lightThemeColors

    LaunchedEffect(language) {
        val localeCode = if (language == AppLanguage.ARABIC) "ar" else "en"
        val locale = Locale(localeCode)
        Locale.setDefault(locale)

        // 2. تحديث الإعدادات باستخدام نسخة جديدة تماماً
        val config = Configuration(currentConfig)
        config.setLocale(locale)

        // تحديث الـ Resources الفعلي للأبلكيشن
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

    val layoutDirection = if (language == AppLanguage.ARABIC) {
        LayoutDirection.Rtl
    } else {
        LayoutDirection.Ltr
    }

    val activity = context as? Activity
    val view = LocalView.current

    if (activity != null) {
        activity.window.navigationBarColor = theme.blurOverly.toArgb()
        WindowCompat.getInsetsController(activity.window, view).isAppearanceLightStatusBars = !isDarkTheme
    }

    CompositionLocalProvider(
        LocalDecoratoAppColors provides theme,
        LocalIsDarkTheme provides isDarkTheme,
        LocalLayoutDirection provides layoutDirection,
        LocalNavManager provides NavigationManager(rememberNavController())
    ) {
        content()
    }
}

val LocalIsDarkTheme = compositionLocalOf<Boolean> {
    error("LocalIsDarkTheme not provided")
}
