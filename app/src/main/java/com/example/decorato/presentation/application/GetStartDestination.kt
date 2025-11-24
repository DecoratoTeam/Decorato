package com.example.decorato.presentation.application

import com.example.decorato.presentation.navigation.Route
import com.example.decorato.presentation.viewModel.ApplicationUiState

fun getStartDestination(startDestinations: ApplicationUiState.StartDestinations?): Route? {
    return when (startDestinations) {
        ApplicationUiState.StartDestinations.HOME -> Route.Tab.Home
        ApplicationUiState.StartDestinations.LOGIN -> Route.Login
        ApplicationUiState.StartDestinations.ON_BOARDING -> Route.Onboarding
        null -> null
    }
}