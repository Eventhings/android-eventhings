package com.eventhngs.domain.model

enum class EventNeedItemType {
    MEDIA_PARTNER, SPONSOR, EQUIPMENT
}

data class EventNeedItem(
    val id: String = "",
    val logo: String = "",
    val title: String = "",
    val label: List<String> = emptyList(),
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val type: EventNeedItemType = EventNeedItemType.EQUIPMENT
)
