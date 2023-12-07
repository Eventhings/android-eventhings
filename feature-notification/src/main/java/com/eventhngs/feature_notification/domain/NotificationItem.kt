package com.eventhngs.feature_notification.domain

import androidx.annotation.DrawableRes

data class NotificationItem(
    val id: Int,
    @DrawableRes
    val icon: Int,
    val title: String,
    val description: String,
    val date: String
)
