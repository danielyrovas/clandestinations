package org.yrovas.clandestinations.data

data class Game(
    val identity: Identity,
    var newGame: Boolean = false,
    var intel: Int = 0,
    var actions: MutableList<Action> = mutableListOf(),
    var tasks: MutableList<Task> = mutableListOf(),
) {
    fun save() {
    }
}
