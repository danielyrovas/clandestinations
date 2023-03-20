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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DisplayIdentity() {
    Box(modifier = Modifier)
}

@Composable
fun TaskListItem() {
    Box(modifier = Modifier
        .height(50.dp)
        .width(300.dp)
        //.padding(4.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(Color.DarkGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.align(Alignment.CenterStart)
            .padding(start = 10.dp)
        ) {
            Box(
                Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.Black)
            )
            Text("Task Name", Modifier
                .padding(start = 5.dp) )
        }
        LinearProgressIndicator(
            Modifier.align(Alignment.CenterEnd)
                .padding(start = 10.dp, end = 10.dp)
                .width(100.dp)
        )
    }
}

@Preview
@Composable
fun TaskListItemPreview() {
    TaskListItem()
}