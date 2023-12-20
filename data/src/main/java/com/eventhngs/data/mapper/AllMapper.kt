package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.AllItem
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType

fun List<AllItem>.toEventNeeds(): List<EventNeedItem> {
    return map { it.toEventNeed() }
}

fun AllItem.toEventNeed(): EventNeedItem {
    val type = when (serviceType) {
        "media-partner" -> EventNeedItemType.MEDIA_PARTNER
        "sponsorship" -> EventNeedItemType.SPONSOR
        else -> EventNeedItemType.EQUIPMENT
    }
    val label = when (serviceType) {
        "media-partner" -> "Media Partner"
        "sponsorship" -> "Sponsor"
        else -> "Equipment"
    }
    return EventNeedItem(
        id = id ?: "",
        logo = logoUrl ?: "",
        title = name ?: "",
        label = listOf(label, field ?: ""),
        price = minPrice ?: 0.0,
        rating = averageRating?.toDoubleOrNull() ?: 0.0,
        type = type
    )
}