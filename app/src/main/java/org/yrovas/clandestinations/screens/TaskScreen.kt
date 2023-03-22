package org.yrovas.clandestinations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.R
import org.yrovas.clandestinations.data.StaticData
import org.yrovas.clandestinations.data.Task

@Composable
fun TaskScreen(nav: NavHostController, task: Task) {
    val txtHead = Modifier.padding(
        start = 20.dp,
        top = 10.dp, bottom = 10.dp
    )
    val space = Modifier.height(10.dp)

    Surface {
        Column {
            Spacer(modifier = Modifier.padding(10.dp))
            Text(task.name, modifier = txtHead)
            if (task.subtasks != null) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    items(task.subtasks) { task ->
                        TaskListScreenItem(task = task)
                        Spacer(modifier = space)
                    }
                }
            }
        }
    }
}

@Composable
fun TaskListScreenItem(task: Task) {
    var complete by remember { mutableStateOf(task.complete) }
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.DarkGray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        ) {
            Box(
                Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.Black)
            )
            Text(
                task.name, Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(0.85f)
            )
        }
        Button(
            onClick = {
                complete = !complete
                task.complete = !task.complete
            },
            contentPadding = PaddingValues(5.dp),
            modifier = Modifier
                .padding(end = 10.dp)
                .defaultMinSize(minWidth = 8.dp, minHeight = 5.dp)
                .align(Alignment.CenterEnd)
        ) {
            val icon = if (complete) painterResource(id = R.drawable.baseline_check_24)
            else painterResource(id = R.drawable.baseline_access_time_24)
            Image(painter = icon, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun TaskScreenPreview() {
    TaskScreen(
        rememberNavController(), StaticData.previewGame.tasks[0]
    )
}