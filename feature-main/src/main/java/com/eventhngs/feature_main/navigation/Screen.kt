package com.eventhngs.feature_main.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Chat : Screen(route = "chat")
    object Notification : Screen(route = "notification")
    object Profile : Screen(route = "profile")
}