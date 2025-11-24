package com.example.decorato.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: Route = Route.Tab.Home
) {
    NavHost(navController = navController, startDestination = startDestination) {



    }
}