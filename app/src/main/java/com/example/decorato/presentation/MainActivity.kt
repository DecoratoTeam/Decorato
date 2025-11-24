package com.example.decorato.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.decorato.presentation.navigation.NavGraph
import com.example.decorato.presentation.navigation.Route
import com.example.decorato.presentation.theme.DecoratoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecoratoTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    startDestination = Route.Onboarding
                )
            }
        }
    }
}