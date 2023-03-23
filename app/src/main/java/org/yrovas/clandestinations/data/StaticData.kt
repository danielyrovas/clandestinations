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
            Disguise("FBI Agent", R.drawable.embassy,"A veteran of thirty years who has bribed every city official, judge or magistrate. No one is off their books. Willing to lie, blackmail or plant evidence to get ahead of the pack is part of their skill set for anyone who gets in their way. "),
            Disguise("Drug Dealer", R.drawable.dealer, "This dealer has grown up believing that trafficking is the only way to make money. Passed on the tricks of the trade from their parents, they have no conscience and will do whatever it takes  to score big despite having prior convictions."),
            Disguise("Cleaner", R.drawable.cleaner, "Happy to keep to themselves, enjoys listening to their mp3 while getting the cleaning done. Not aware of what is going on around them however something random will make them discreetly  adjust what they are doing and  silently observe while still cleaning. "),
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