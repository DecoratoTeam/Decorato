package com.example.decorato.presentation.screens.onBoarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.onboardingScreenRoute() {
    composable<Route.Onboarding> {
        OnboardingScreen()
    }
}