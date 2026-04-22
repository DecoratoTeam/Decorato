package com.example.decorato.presentation.navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.decorato.presentation.screens.profile.EditProfileScreen
import com.example.decorato.presentation.screens.profile.MyPostsScreen
import com.example.decorato.presentation.screens.profile.MyRatingScreen
import com.example.decorato.presentation.screens.profile.ProfileScreen
import com.example.decorato.presentation.viewModel.profile.ViewModel.ProfileViewModel
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
// 1. دي لتعريف شاشة البروفايل الأساسية
fun NavGraphBuilder.profileScreenRoute(navigationManager: NavigationManager) {
    composable<Route.Tab.Profile> {
        ProfileScreenRoute(navigationManager = navigationManager)
    }
}

// 2. دي لتعريف شاشة تقييماتي
fun NavGraphBuilder.myRatingScreenRoute(navController: NavHostController) {
    composable(route = "my_rating_route") {
        MyRatingScreen(onBackClick = { navController.popBackStack() })
    }
}

// 3. دي لتعريف شاشة منشوراتي
fun NavGraphBuilder.myPostsScreenRoute(navigationManager: NavigationManager) {
    composable(route = "my_posts_route") {
        MyPostsScreen(onBackClick = { navigationManager.navigateBack() })
    }
}

// 4. دي لتعريف شاشة تعديل البروفايل
fun NavGraphBuilder.editProfileScreenRoute(navigationManager: NavigationManager) {
    composable(route = "edit_profile_route") {
        EditProfileScreen(onBackClick = { navigationManager.navigateBack() })
    }
}

