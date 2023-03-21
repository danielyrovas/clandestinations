package org.yrovas.clandestinations

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.components.TaskListItem
import org.yrovas.clandestinations.data.Game
import org.yrovas.clandestinations.data.Identity
import org.yrovas.clandestinations.data.Task
import org.yrovas.clandestinations.data.randomIdentity
import org.yrovas.clandestinations.ui.theme.ClandestinationsTheme

@Composable
fun WelcomeScreen(nav: NavHostController, game: Game) {
    Surface {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            if (game.newGame) {
                Spacer(Modifier.height(500.dp))
                Button(onClick = { nav.navigate(Screen.Character.route)
                },
                ) {
                    Text(text = "Start Game")
                }
            } else {
                DisplayCharacterBadge(Modifier.height(500.dp), game.identity)
                Spacer(Modifier.height(100.dp))
                Button(
                    onClick = {
                        nav.navigate(Screen.Main.route)
                    },
                ) {
                    Text(text = "Continue Game")
                }
            }
        }
    }
}

@Composable
fun DisplayCharacterBadge(modifier: Modifier, identity: Identity) {
    Box(modifier = modifier) {
        Text(identity.disguise.role,
            modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(nav: NavHostController = rememberNavController()) {
    ClandestinationsTheme {
        WelcomeScreen(nav, Game(randomIdentity(), newGame = true))
    }
}