package com.example.decorato.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.decorato.presentation.screens.community.communityScreenRoute
import com.example.decorato.presentation.screens.generate.generateScreenRoute
import com.example.decorato.presentation.screens.home.homeScreenRoute
import com.example.decorato.presentation.screens.login.loginScreenRoute
import com.example.decorato.presentation.screens.onBoarding.onboardingScreenRoute
import com.example.decorato.presentation.screens.profile.profileScreenRoute
import com.example.decorato.presentation.screens.register.registerScreenRoute

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Route
) {
    NavHost(navController = navController, startDestination = startDestination) {
        // Auth & Onboarding
        onboardingScreenRoute()
        registerScreenRoute()
        loginScreenRoute()

        // Main App Screens with Bottom Navigation
        homeScreenRoute()
        generateScreenRoute()
        communityScreenRoute()
        profileScreenRoute()
    }
}
