package com.eventhngs.feature_main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.eventhngs.feature_profile.profile.ProfileScreen
import com.eventhngs.feature_saved_item.SavedItemScreen
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
            BottomBar(
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
            )
        },
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .offset(y = 40.dp)
                    .clip(CircleShape)
                    .clickable { mainNavigator.navigateToAddBusinessMenuScreen() }
                    .size(48.dp)
                    .background(Color(0xFF9365CD)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier.size(34.dp)
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
                    navigateToEquipmentMenuScreen = mainNavigator::navigateToEquipmentRentalMenuScreen,
                    navigateToMediaPartnerDetailScreen = mainNavigator::navigateToMediaPartnerDetailScreen,
                    navigateToSponsorDetailScreen = mainNavigator::navigateToSponsorDetailScreen,
                    navigateToEquipmentDetailScreen = mainNavigator::navigateToEquipmentDetailScreen
                )
            }
            composable(Screen.Chat.route) {
                ListChatScreen(
                    navigateToChatDetailScreen = mainNavigator::navigateToChatDetailScreen
                )
            }
            composable(Screen.Notification.route) {
                SavedItemScreen(
                    navigateToMediaPartnerDetailScreen = mainNavigator::navigateToMediaPartnerDetailScreen,
                    navigateToSponsorDetailScreen = mainNavigator::navigateToSponsorDetailScreen,
                    navigateToEquipmentDetailScreen = mainNavigator::navigateToEquipmentDetailScreen
                )
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
