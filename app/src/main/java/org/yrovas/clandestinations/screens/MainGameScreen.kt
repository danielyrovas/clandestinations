package org.yrovas.clandestinations

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.components.ActionListItem
import org.yrovas.clandestinations.components.TaskListItem
import org.yrovas.clandestinations.data.*
import org.yrovas.clandestinations.ui.theme.ClandestinationsTheme

@Composable
fun MainGameScreen(nav: NavHostController, game: Game) {
    Surface {
        Column {
            val txtHead = Modifier
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
            val space = Modifier.height(5.dp)
            Text("Tasks", modifier = txtHead)
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
            ) {
                items(game.tasks) {
                        task -> TaskListItem(task = task)
                }
            }
            Text("Actions", modifier = txtHead)
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
            ) {
                items(game.actions) {
                        action -> ActionListItem(action = action)
                    Spacer(modifier = space)
                }
            }
        }
    }
}


@Preview
@Composable
fun MainGameScreenPreview(navHostController: NavHostController = rememberNavController()) {
    ClandestinationsTheme {
        MainGameScreen(navHostController, Game(randomIdentity(),
            tasks = StaticData.tasks.toMutableList(),
            actions = StaticData.actions.toMutableList(),
        ))
    }
}