package org.yrovas.clandestinations.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.data.Game
import org.yrovas.clandestinations.data.Identity
import org.yrovas.clandestinations.data.StaticData
import org.yrovas.clandestinations.data.randomIdentity

@Composable
fun CharacterScreen(nav: NavHostController?, game: Game) {
    Surface {
        Column {
            Text(text = "You are playing as:")
            Text(text = game.identity.name)
            Text(text = game.identity.address)
            Text(text = game.identity.agentID.toString())
            Text(text = game.identity.disguise.role)
        }
    }
}

@Composable
@Preview()
fun CharacterScreen() {
    CharacterScreen(nav = rememberNavController(), game = StaticData.previewGame)
}