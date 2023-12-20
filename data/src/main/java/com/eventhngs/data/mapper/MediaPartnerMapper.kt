package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.MediaPartnerItem
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType

fun List<MediaPartnerItem>.toEventNeeds(): List<EventNeedItem> {
    return map { it.toEventNeed() }
}

fun MediaPartnerItem.toEventNeed(): EventNeedItem {
    return EventNeedItem(
        id = id ?: "",
        logo = logoUrl ?: "",
        title = name ?: "",
        label = listOf("Media Partner", field ?: ""),
        price = minPrice ?: 0.0,
        rating = averageRating?.toDoubleOrNull() ?: 0.0,
        type = EventNeedItemType.MEDIA_PARTNER
    )
}