package com.example.decorato.presentation.screens.generate.chat

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.Route

fun NavGraphBuilder.generateChatScreenRoute() {
    composable<Route.GenerateChat> {
        GenerateChatScreen()
    }
}