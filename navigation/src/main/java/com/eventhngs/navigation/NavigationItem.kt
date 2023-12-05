package com.eventhngs.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.eventhngs.navigation.Screen

sealed class NavigationItem (
    val title: String,
    val icon: ImageVector,
    val screen: Screen

)