package com.example.decorato.presentation.screens.register

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.registerScreenRoute() {
    composable<Route.Register> {
        RegisterScreen()
    }
}