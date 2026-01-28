package com.example.decorato.presentation.screens.community

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.communityScreenRoute() {
    composable<Route.Tab.Community> {
        CommunityScreen()
    }
}