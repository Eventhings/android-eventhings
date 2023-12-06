package com.eventhngs.feature_main.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Chat
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eventhngs.feature_main.navigation.NavigationItem
import com.eventhngs.feature_main.navigation.Screen

@Composable
fun BottomBar(
    navController: NavHostController,
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = Icons.Rounded.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Chat",
                icon = Icons.Rounded.Chat,
                screen = Screen.Chat
            ),
            NavigationItem(
                title = "Notification",
                icon = Icons.Rounded.Notifications,
                screen = Screen.Notification
            ),
            NavigationItem(
                title = "Profile",
                icon = Icons.Rounded.Person,
                screen = Screen.Profile
            ),
        )

        navigationItems.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.screen.route } == true,
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = screen.title)
                },
                onClick = {
                    navController.navigate(screen.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
