package org.yrovas.clandestinations.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.Screen
import org.yrovas.clandestinations.data.Game
import org.yrovas.clandestinations.data.Identity
import org.yrovas.clandestinations.data.StaticData
import org.yrovas.clandestinations.data.randomIdentity

@Composable
fun CharacterScreen(nav: NavHostController, game: Game) {
    var game by remember { mutableStateOf(game) }
    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "You are playing as:")
            Text(text = "Name: ${game.identity.name}")
            Text(text = "Origin: ${game.identity.address}")
            Text(text = "Agent ID: ${game.identity.agentID}")
            Text(text = "Disguise: ${game.identity.disguise.role}")

            Button(
                onClick = {
                    nav.navigate(Screen.Main.route) {
                        popUpTo(nav.graph.id)
                    }
                },
            ) {
                Text(text = "Continue Game")
            }
            Button(modifier = Modifier.padding(20.dp), onClick = {
                game.new()
                Log.d("RAND", "CharacterScreen: ${game.identity.name}")
                nav.navigate(Screen.Welcome.route) {
                    popUpTo(nav.graph.id) {
                        inclusive = true
                    }
                }
            }) { Text(text = "New Game") }

        }
    }
}

@Composable
@Preview()
fun CharacterScreen() {
    CharacterScreen(nav = rememberNavController(), game = StaticData.previewGame)
}