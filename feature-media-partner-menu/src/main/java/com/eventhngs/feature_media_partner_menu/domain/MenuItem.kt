package com.eventhngs.feature_media_partner_menu.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MenuItem(
    @DrawableRes
    val icon: Int,
    @StringRes
    val label: Int
)