package org.yrovas.clandestinations.data

data class Task(
    val name: String,
    var complete: Boolean = false,
    val icon: String? = null,
    val subtasks: List<Task>? = null,
    val intel: Int = 0,
)