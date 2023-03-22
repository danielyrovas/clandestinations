package org.yrovas.clandestinations.data

data class Task(
    val name: String,
    var complete: Boolean = false,
    val icon: Int,
    val subtasks: List<Task>? = null,
    val intel: Int = 0,
)