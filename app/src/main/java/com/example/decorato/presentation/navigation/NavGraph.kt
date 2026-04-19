package com.example.decorato.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.decorato.presentation.screens.community.communityScreenRoute
import com.example.decorato.presentation.screens.generate.chat.generateChatScreenRoute
import com.example.decorato.presentation.screens.generate.generateScreenRoute
import com.example.decorato.presentation.screens.home.detailsScreen.designDetailsScreenRoute
import com.example.decorato.presentation.screens.home.detailsScreen.styleDetailsScreenRoute
import com.example.decorato.presentation.screens.home.homeScreenRoute
import com.example.decorato.presentation.screens.login.loginScreenRoute
import com.example.decorato.presentation.screens.onBoarding.onboardingScreenRoute
import com.example.decorato.presentation.screens.profile.EditProfileScreen
import com.example.decorato.presentation.screens.profile.MyPostsScreen
import com.example.decorato.presentation.screens.profile.MyRatingScreen
import com.example.decorato.presentation.screens.register.registerScreenRoute

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Route,
    navigationManager: NavigationManager
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // 1. شاشات الـ Auth & Onboarding (Extension Functions)
        onboardingScreenRoute()
        registerScreenRoute()
        loginScreenRoute()

        // Main App Screens with Bottom Navigation
        homeScreenRoute()
        generateScreenRoute()
        communityScreenRoute()
        profileScreenRoute()

        styleDetailsScreenRoute()
        designDetailsScreenRoute()
    }
}
