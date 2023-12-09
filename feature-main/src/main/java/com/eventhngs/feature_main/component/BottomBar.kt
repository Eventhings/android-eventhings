package com.eventhngs.feature_main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eventhngs.feature_main.R
import com.eventhngs.feature_main.navigation.NavigationItem
import com.eventhngs.feature_main.navigation.Screen

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val home = NavigationItem(
        title = "Home",
        screen = Screen.Home,
        icon = R.drawable.ic_home,
        iconActive = R.drawable.ic_home_active
    )
    val chat = NavigationItem(
        title = "Chat",
        screen = Screen.Chat,
        icon = R.drawable.ic_chat,
        iconActive = R.drawable.ic_chat_active
    )
    val notification = NavigationItem(
        title = "Notification",
        screen = Screen.Notification,
        icon = R.drawable.ic_notification,
        iconActive = R.drawable.ic_notification_active
    )
    val profile = NavigationItem(
        title = "Profile",
        screen = Screen.Profile,
        icon = R.drawable.ic_profile,
        iconActive = R.drawable.ic_profile_active
    )
    Row(
        modifier = modifier
//            .shadow(10.dp, clip = true)
            .background(Color.White)
            .padding(horizontal = 28.dp)
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {
                navController.navigate(home.screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any { it.route == home.screen.route } == true
            val icon = if (selected) {
                home.iconActive
            } else {
                home.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = home.title
            )
        }
        IconButton(
            onClick = {
                navController.navigate(chat.screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any { it.route == chat.screen.route } == true
            val icon = if (selected) {
                chat.iconActive
            } else {
                chat.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = chat.title
            )
        }
        Spacer(modifier = Modifier.width(26.dp))
        IconButton(
            onClick = {
                navController.navigate(notification.screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any { it.route == notification.screen.route } == true
            val icon = if (selected) {
                notification.iconActive
            } else {
                notification.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = notification.title
            )
        }
        IconButton(
            onClick = {
                navController.navigate(profile.screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        ) {
            val selected = currentDestination?.hierarchy?.any { it.route == profile.screen.route } == true
            val icon = if (selected) {
                profile.iconActive
            } else {
                profile.icon
            }
            Image(
                painter = painterResource(id = icon),
                contentDescription = profile.title
            )
        }
    }
}
