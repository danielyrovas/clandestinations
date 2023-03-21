package org.yrovas.clandestinations.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.yrovas.clandestinations.data.Action
import org.yrovas.clandestinations.data.Task

@Composable
fun DisplayIdentity() {
    Box(modifier = Modifier)
}

@Composable
fun TaskListItem(task: Task) {
    var taskProgress = 0.0f
    if (task.subtasks != null) {
        taskProgress = task.subtasks.count { it.complete }.toFloat()/task.subtasks.size
    }
    Box(modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()
        //.padding(4.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(Color.DarkGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
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
            Text(task.name, Modifier
                .padding(start = 5.dp) )
        }
        LinearProgressIndicator(progress = taskProgress,
            Modifier
                .align(Alignment.CenterEnd)
                .padding(start = 10.dp, end = 10.dp)
                .width(100.dp)
                .height(18.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun ActionListItem(action: Action) {
    Box(modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()
        //.padding(4.dp)
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
                action.name, Modifier
                    .padding(start = 5.dp)
            )
        }
    }
}

@Preview
@Composable
fun TaskListItemPreview() {
    TaskListItem(Task(name = "Sneak Info", intel = 50, subtasks = listOf(
        Task("name", complete = true),
        Task("name", complete = true),
        Task("name"),
        Task("name"),
    )))
}
@Preview
@Composable
fun ActionListItemPreview() {
    ActionListItem(action = Action("Eliminate"))
}
