package com.example.decorato.presentation.screens.home.detailsScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.designDetailsScreenRoute() {
    composable<Route.DesignDetails> { backStackEntry ->
        val args = backStackEntry.arguments
        val designId = args?.getString("designId") ?: ""
        DesignDetailsScreen(designId = designId)
    }
}