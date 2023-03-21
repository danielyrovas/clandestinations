package org.yrovas.clandestinations

import org.yrovas.clandestinations.data.Action
import org.yrovas.clandestinations.data.Disguise
import org.yrovas.clandestinations.data.Task


class StaticData() {
    companion object {
        val disguises: List<Disguise> = listOf(
            Disguise("FBI Agent"),
            Disguise("Mechanic"),
        )
        val actions: List<Action> = listOf()
        val tasks: List<Task> = listOf(
            Task(name = "Gather Security Intel", subtasks = listOf(
                Task("Find Secure Door Lock or Keypad"),
                Task("Photograph security detail"),
            ), intel = 50),
        )
    }
}