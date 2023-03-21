package org.yrovas.clandestinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.yrovas.clandestinations.data.Identity

@Composable
fun SetupNavGraph(
    navHostController: NavHostController,
    newGame: Boolean,
    identity: Identity,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Welcome.route,
    ) {
        composable( route = Screen.Welcome.route
        ) {
            WelcomeScreen(navHostController, newGame, identity)
        }
        composable( route = Screen.Main.route
        ) {
            MainGameScreen(navHostController)
        }
        composable( route = Screen.Character.route
        ) {
            WelcomeScreen(navHostController, newGame, identity)
        }
    }
}