package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.EquipmentItem
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType

fun List<EquipmentItem>.toEventNeeds(): List<EventNeedItem> {
    return map { it.toEventNeed() }
}

fun EquipmentItem.toEventNeed(): EventNeedItem {
    return EventNeedItem(
        id = id ?: "",
        logo = logoUrl ?: "",
        title = name ?: "",
        label = listOf("Media Partner", field ?: ""),
        price = minPrice ?: 0.0,
        rating = averageRating?.toDoubleOrNull() ?: 0.0,
        type = EventNeedItemType.EQUIPMENT
    )
}