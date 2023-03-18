package org.yrovas.clandestinations

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Character : Screen("character_details")
    object Main : Screen("main")
}
