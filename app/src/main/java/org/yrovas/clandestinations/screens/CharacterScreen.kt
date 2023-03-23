package org.yrovas.clandestinations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            val txtHead = Modifier.padding(start = 20.dp,
                top = 10.dp, bottom = 10.dp)
            val space = Modifier.height(10.dp)
            Text("Identity", modifier = txtHead)
            Image(
                painter = painterResource(id = game.identity.disguise.icon),
                contentDescription = "",
                modifier = Modifier
                    .padding(40.dp,10.dp)
                    .size(260.dp)
                    .border(3.dp, Color.Black)
                    .align(Alignment.CenterHorizontally)
            )
            Column(Modifier.padding(20.dp, 0.dp, 20.dp, 10.dp)) {
                Text(text = "You are playing as:")
                Text(text = game.identity.name)
                Text(text = game.identity.address)
                Text(text = game.identity.agentID.toString())
                Text(text = game.identity.disguise.role)
                Text(text = game.identity.disguise.description, modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp))
            }
        }
    }
}

@Composable
@Preview()
fun CharacterScreen() {
    CharacterScreen(nav = rememberNavController(), game = StaticData.previewGame)
}