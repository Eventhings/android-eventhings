package com.eventhngs.feature_main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eventhngs.feature_chat.list.ListChatScreen
import com.eventhngs.feature_home.HomeScreen
import com.eventhngs.feature_main.component.BottomBar
import com.eventhngs.feature_main.navigation.EmptyMainNavigator
import com.eventhngs.feature_main.navigation.MainNavigator
import com.eventhngs.feature_main.navigation.Screen
import com.eventhngs.feature_notification.NotificationScreen
import com.eventhngs.feature_profile.profile.ProfileScreen
import com.eventhngs.ui.theme.EventhngsTheme

@ExperimentalFoundationApi
@ExperimentalLayoutApi
@ExperimentalMaterial3Api
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    mainNavigator: MainNavigator
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        floatingActionButton = {
            SmallFloatingActionButton(
                onClick = mainNavigator::navigateToAddBusinessMenuScreen,
                modifier = Modifier.offset(y = 30.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding() - 48.dp)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToAllMenuScreen = mainNavigator::navigateToAllMenuScreen,
                    navigateToMediaPartnerMenuScreen = mainNavigator::navigateToMediaPartnerMenuScreen,
                    navigateToSponsorMenuScreen = mainNavigator::navigateToSponsorMenuScreen,
                    navigateToEquipmentMenuScreen = mainNavigator::navigateToEquipmentRentalMenuScreen
                )
            }
            composable(Screen.Chat.route) {
                ListChatScreen()
            }
            composable(Screen.Notification.route) {
                NotificationScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(
                    navigateToEditProfileScreen = mainNavigator::navigateToEditProfileScreen
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalLayoutApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewMainScreen() {
    EventhngsTheme {
        Surface {
            MainScreen(
                mainNavigator = EmptyMainNavigator
            )
        }
    }
}
