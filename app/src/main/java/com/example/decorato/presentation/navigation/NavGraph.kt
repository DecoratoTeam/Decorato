package com.example.decorato.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.decorato.presentation.screens.onBoarding.onboardingScreenRoute


@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Route = Route.Onboarding
) {
    NavHost(navController = navController, startDestination = startDestination) {
        onboardingScreenRoute()
    }
}