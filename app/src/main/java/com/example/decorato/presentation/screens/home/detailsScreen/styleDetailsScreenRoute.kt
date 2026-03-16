package com.example.decorato.presentation.screens.home.detailsScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.styleDetailsScreenRoute() {
    composable<Route.StyleDetails> { backStackEntry ->
        val args = backStackEntry.arguments
        val styleId = args?.getString("styleId") ?: ""
        StyleDetailsScreen(styleId = styleId)
    }
}