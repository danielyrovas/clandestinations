package org.yrovas.clandestinations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.R
import org.yrovas.clandestinations.Screen
import org.yrovas.clandestinations.components.ActionListItem
import org.yrovas.clandestinations.components.TaskListItem
import org.yrovas.clandestinations.data.*
import org.yrovas.clandestinations.ui.theme.ClandestinationsTheme

@Composable
fun MainGameScreen(nav: NavHostController, game: Game) {
    var intel by remember { mutableStateOf(game.intel) }
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {

                val txtHead = Modifier.padding(
                    start = 20.dp, top = 10.dp, bottom = 10.dp
                )
                val space = Modifier.height(10.dp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cleaner), contentDescription = "",
                        modifier = Modifier.clickable {
                            nav.navigate(Screen.Character.route)
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
                    ) {
                        Text("Intel")
                        Spacer(modifier = Modifier.width(30.dp))
                        Text("$intel")
                    }
                }
                Text("Tasks", modifier = txtHead)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    itemsIndexed(game.tasks) { index, task ->
                        TaskListItem(task = task) {
                            nav.navigate(Screen.Task.index(index))
                        }
                        Spacer(modifier = space)
                    }
                }
                Text("Actions", modifier = txtHead)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    items(game.actions) { action ->
                        ActionListItem(action = action) {
                            nav.navigate(Screen.Eliminate.route)
                        }
                        Spacer(modifier = space)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun MainGameScreenPreview() {
    ClandestinationsTheme {
        MainGameScreen(rememberNavController(), StaticData.previewGame)
    }
}