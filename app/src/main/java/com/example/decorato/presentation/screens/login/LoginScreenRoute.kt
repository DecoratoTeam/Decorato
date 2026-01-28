package com.example.decorato.presentation.screens.login

import LoginScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.loginScreenRoute() {
    composable<Route.Login> {
        LoginScreen()
    }
}
