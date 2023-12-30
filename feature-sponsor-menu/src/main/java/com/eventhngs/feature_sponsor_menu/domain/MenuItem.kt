package com.eventhngs.feature_sponsor_menu.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MenuItem(
    @DrawableRes
    val icon: Int,
    @StringRes
    val label: Int
)