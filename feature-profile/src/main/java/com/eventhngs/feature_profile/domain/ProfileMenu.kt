package com.eventhngs.feature_profile.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ProfileMenu(
    @DrawableRes
    val icon: Int,
    val label: String
)
