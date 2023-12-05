package com.eventhngs.ui.component.navbottom

import androidx.compose.material.BottomNavigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Chat
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.eventhngs.navigation.NavigationItem
import com.eventhngs.navigation.Screen

@Composable
fun BottomBar(
    navController: NavHostController,
    currentRoute: String?,
) {

    val navigationItems = listOf(
        NavigationItem(
            title = "home",
            icon = Icons.Rounded.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = "chat",
            icon = Icons.Rounded.Chat,
            screen = Screen.Chat
        ),
        NavigationItem(
            title = "notification",
            icon = Icons.Rounded.Notifications,
            screen = Screen.Notification
        ),
        NavigationItem(
            title = "profile",
            icon = Icons.Rounded.Person,
            screen = Screen.Profile
        ),
    )

    BottomNavigation()

}
