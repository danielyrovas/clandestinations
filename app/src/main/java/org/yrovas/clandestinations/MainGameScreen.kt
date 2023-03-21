package org.yrovas.clandestinations

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.data.Game
import org.yrovas.clandestinations.data.randomIdentity
import org.yrovas.clandestinations.ui.theme.ClandestinationsTheme

@Composable
fun MainGameScreen(nav: NavHostController, game: Game) {
    Surface {
        Text("Main Game Screen")
    }
}

@Preview
@Composable
fun MainGameScreenPreview(navHostController: NavHostController = rememberNavController()) {
    ClandestinationsTheme {
        MainGameScreen(navHostController, Game(randomIdentity()))
    }
}