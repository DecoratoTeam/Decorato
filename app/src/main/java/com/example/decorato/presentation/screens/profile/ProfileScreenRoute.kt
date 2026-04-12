package com.example.decorato.presentation.navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.screens.profile.ProfileScreen
import com.example.decorato.presentation.screens.profile.ProfileViewModel
import com.example.decorato.presentation.viewModel.ApplicationViewModel

@Composable
fun ProfileScreenRoute(
    navigationManager: NavigationManager,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    // الزيتونة: استخدام LocalActivity بدل الكاستينج اليدوي لضمان الوصول للـ Activity الصح
    val activity = LocalActivity.current as? ComponentActivity

    // بنمرر الـ activity كـ owner للـ ViewModel عشان نضمن إنها نفس النسخة (Shared ViewModel)
    val appViewModel: ApplicationViewModel = if (activity != null) {
        hiltViewModel(activity)
    } else {
        hiltViewModel()
    }

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ProfileEffect.NavigationToLogin -> {
                    navigationManager.toLogin(clearBackStack = true)
                }
                is ProfileEffect.NavigationToEditProfile -> {
                    navigationManager.toEditProfile()
                }
                is ProfileEffect.NavigationToMyPosts -> {
                    navigationManager.toMyPosts()
                }
                is ProfileEffect.NavigationToMyRating -> {
                    navigationManager.toMyRating()
                }

                is ProfileEffect.ChangeLanguage -> {
                    appViewModel.onChangeLanguage(effect.language)
                }

                is ProfileEffect.ChangeTheme -> {
                    appViewModel.onChangeTheme(effect.isDark)
                }

                else -> {}
            }
        }
    }

    ProfileScreen(
        state = state,
        listener = viewModel
    )
}