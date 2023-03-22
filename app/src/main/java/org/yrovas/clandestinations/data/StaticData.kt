package org.yrovas.clandestinations.data

import androidx.compose.ui.unit.dp
import org.yrovas.clandestinations.R
import org.yrovas.clandestinations.data.Action
import org.yrovas.clandestinations.data.Disguise
import org.yrovas.clandestinations.data.Task
import java.lang.reflect.Modifier


class StaticData() {
    companion object {
        val disguises: List<Disguise> = listOf(
            Disguise("FBI Agent", "NOPE"),
            Disguise("Mechanic", "NOPE"),
        )
        val actions: List<Action> = listOf(
            Action("Eliminate"),
            Action("Share Info"),
            Action("Rest")
        )
        val tasks: List<Task> = listOf(
            Task(name = "Gather Security Intel", icon = R.drawable.gather_intel, subtasks = listOf(
                Task("Find Secure Door Lock or Keypad", complete = true, icon = R.drawable.infiltrate),
                Task("Photograph security detail", icon = R.drawable.gather_intel),
            ), intel = 50),
            Task(name = "Infiltrate", icon = R.drawable.infiltrate,subtasks = listOf(
                Task("Enter a building", complete = true, icon = R.drawable.infiltrate),
                Task("Photograph point of interest", icon = R.drawable.gather_intel),
            ), intel = 50),
            Task(name = "Eavesdrop", icon = R.drawable.remember_code, subtasks = listOf(
                Task("Record conversation", icon = R.drawable.contact),
            ), intel = 50),
        )
        val previewGame: Game = Game(tasks = tasks.toMutableList(),
            actions = actions.toMutableList(),
            identity = Identity(name = "John Knawledge", 99, 0, "Ontario, CA")
        )
    }
}