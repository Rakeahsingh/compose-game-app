package com.example.gameapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gameapp.presentation.GameDetailsScreen
import com.example.gameapp.presentation.GameScreen
import com.example.gameapp.presentation.HomeScreen
import com.example.gameapp.ui.theme.GameAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameAppTheme {
                // A surface container using the 'background' color from the theme

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home_screen"
                )
                {
                    composable("home_screen") {
                        HomeScreen(navController = navController)
                    }
                    composable("game_screen") {
                        GameScreen(navController = navController)
                    }
                    composable("game_details/{gameId}",
                        arguments = listOf(
                        navArgument("gameId") {
                            type = NavType.IntType

                        }
                        )
                    ) {
                        val gameName = remember {
                            it.arguments?.getInt("gameId")
                        }
                        GameDetailsScreen(navController = navController)
                    }
                }
            }
        }
    }
}

