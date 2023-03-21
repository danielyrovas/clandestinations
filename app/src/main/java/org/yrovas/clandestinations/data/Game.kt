package org.yrovas.clandestinations.data

data class Game(
    val identity: Identity,
    var newGame: Boolean = false,
    var intel: Int = 0,
    var actions: List<Action> = listOf(),
    var tasks: List<Task> = listOf(),
)
