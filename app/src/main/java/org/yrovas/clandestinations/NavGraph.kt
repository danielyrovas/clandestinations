package org.yrovas.clandestinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.yrovas.clandestinations.data.Game

@Composable
fun SetupNavGraph(
    nav: NavHostController,
    game: Game,
) {
    NavHost(
        navController = nav,
        startDestination = Screen.Welcome.route,
    ) {
        composable( route = Screen.Welcome.route
        ) {
            WelcomeScreen(nav, game)
        }
        composable( route = Screen.Main.route
        ) {
            MainGameScreen(nav, game)
        }
        composable( route = Screen.Character.route
        ) {
            WelcomeScreen(nav, game)
        }
    }
}