package com.eventhngs.domain.model

data class EventNeedItem(
    val id: Int = 0,
    val logo: String = "",
    val title: String = "",
    val label: List<String> = emptyList(),
    val price: Double = 0.0,
    val rating: Double = 0.0,
)
