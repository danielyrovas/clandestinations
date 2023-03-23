package org.yrovas.clandestinations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.yrovas.clandestinations.R
import org.yrovas.clandestinations.data.Game

@Composable
fun EliminateScreen(nav: NavHostController, game: Game) {
    Surface {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("You are under arrest", modifier = Modifier)

            Image(
                painter = painterResource(id = R.drawable.badge),
                contentDescription = "",
                modifier = Modifier
                    .padding(40.dp, 10.dp)
                    .size(260.dp)
            )
        }
    }
}
