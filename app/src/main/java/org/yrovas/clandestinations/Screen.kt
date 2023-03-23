package org.yrovas.clandestinations

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Character : Screen("character_details")
    object Task : Screen("task_details/{taskIndex}") {
        fun index(i: Int) = this.route.replace("{taskIndex}", "$i")
    }

    object Main : Screen("main")
    object Eliminate : Screen("action_eliminate")
}
