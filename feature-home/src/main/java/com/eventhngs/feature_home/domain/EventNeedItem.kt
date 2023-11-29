package com.eventhngs.feature_home.domain

data class EventNeedItem(
    val id: Int = 0,
    val logo: String = "",
    val title: String = "",
    val label: List<String> = emptyList(),
    val price: Double = 0.0,
    val rating: Double = 0.0,
)
