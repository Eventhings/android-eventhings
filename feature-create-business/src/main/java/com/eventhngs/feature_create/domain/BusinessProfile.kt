package com.eventhngs.feature_create.domain

import androidx.compose.ui.text.Placeholder

data class BusinessProfile(
    val photo: String,
    val name: String,
    val description: String = "",
    val value: String,
    val label: String,
    val placeholder: String = "",
    val wordLimit: String,
    val text: String
)