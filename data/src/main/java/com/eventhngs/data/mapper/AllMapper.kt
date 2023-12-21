package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.AllItem
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType

fun List<AllItem>.toEventNeeds(): List<EventNeedItem> {
    return map { it.toEventNeed() }
}

fun AllItem.toEventNeed(): EventNeedItem {
    val type = when  {
        serviceType?.contains("media") == true -> EventNeedItemType.MEDIA_PARTNER
        serviceType?.contains("sponsorship") == true -> EventNeedItemType.SPONSOR
        else -> EventNeedItemType.EQUIPMENT
    }
    val label = when  {
        serviceType?.contains("media") == true -> "Media Partner"
        serviceType?.contains("sponsorship") == true -> "Sponsor"
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