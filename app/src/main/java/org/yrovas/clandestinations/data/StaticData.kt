package org.yrovas.clandestinations.data

import org.yrovas.clandestinations.data.Action
import org.yrovas.clandestinations.data.Disguise
import org.yrovas.clandestinations.data.Task


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
            Task(name = "Gather Security Intel", subtasks = listOf(
                Task("Find Secure Door Lock or Keypad", complete = true),
                Task("Photograph security detail"),
            ), intel = 50),
            Task(name = "Infiltrate", subtasks = listOf(
                Task("Enter a building", complete = true),
                Task("Photograph point of interest"),
            ), intel = 50),
            Task(name = "Eavesdrop", subtasks = listOf(
                Task("Record conversation"),
            ), intel = 50),
        )
        val previewGame: Game = Game(tasks = tasks.toMutableList(),
            actions = actions.toMutableList(),
            identity = Identity(name = "John Knawledge", 99, 0, "Ontario, CA")
        )
    }
}