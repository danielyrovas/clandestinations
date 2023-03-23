package org.yrovas.clandestinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.yrovas.clandestinations.data.Game
import org.yrovas.clandestinations.screens.*

@Composable
fun SetupNavGraph(
    nav: NavHostController,
    game: Game,
) {
    NavHost(
        navController = nav,
        startDestination = Screen.Welcome.route,
    ) {
        composable(
            route = Screen.Welcome.route
        ) {
            WelcomeScreen(nav, game)
        }
        composable(
            route = Screen.Main.route
        ) {
            MainGameScreen(nav, game)
        }
        composable(
            route = Screen.Character.route
        ) {
            CharacterScreen(nav, game)
        }
        composable(
            route = Screen.Eliminate.route
        ) {
            EliminateScreen(nav, game)
        }
        composable(
            route = Screen.Task.route,
            arguments = listOf(navArgument("taskIndex") {
                type = NavType.IntType
            })
        ) {
            val index = it.arguments?.getInt("taskIndex")
            TaskScreen(nav, game.tasks[index!!])
        }
    }
}