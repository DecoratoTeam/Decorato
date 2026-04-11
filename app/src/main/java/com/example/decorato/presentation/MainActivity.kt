package com.example.decorato.presentation

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.presentation.application.DecoratoApp
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.viewModel.ApplicationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {

    private val viewModel: ApplicationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            !viewModel.state.value.isThemeLoaded
                    || !viewModel.state.value.isDestinationLoaded
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appViewModel: ApplicationViewModel = hiltViewModel()
            val state by appViewModel.state.collectAsState()

            LaunchedEffect(state.language) {
                val languageCode = if (state.language == AppLanguage.ARABIC) "ar" else "en"
                val locale = java.util.Locale(languageCode)
                java.util.Locale.setDefault(locale)

                val config = resources.configuration
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics)
            }


            DecoratoTheme(
                isDarkTheme = state.isDarkTheme,
                language = state.language
            ) {
                DecoratoApp()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing && !isChangingConfigurations) {
            if (viewModel.state.value.isDarkTheme) {
                switchIcon(LauncherIcon.DARK, this)
            } else {
                switchIcon(LauncherIcon.LIGHT, this)
            }
        }
    }

    enum class LauncherIcon(
        val aliasName: String,
    ) {
        LIGHT("com.example.decorato.presentation.MainActivity"),
        DARK("com.example.decorato.presentation.DarkLauncher"),
    }

    private fun switchIcon(
        newIcon: LauncherIcon,
        context: Context,
    ) {
        val packageManager = context.packageManager
        val packageName = context.packageName
        LauncherIcon.entries.forEach {
            val componentName = ComponentName(packageName, it.aliasName)
            if (newIcon == it) {
                packageManager.setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP,
                )
            } else {
                packageManager.setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP,
                )
            }
        }
    }
}