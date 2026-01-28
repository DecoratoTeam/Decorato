package com.example.decorato.presentation.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.homeScreenRoute() {
    composable<Route.Tab.Home> {
        HomeScreen()
    }
}