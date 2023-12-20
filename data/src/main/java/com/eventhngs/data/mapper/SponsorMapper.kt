package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.SponsorItem
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.EventNeedItemType

fun List<SponsorItem>.toEventNeeds(): List<EventNeedItem> {
    return map { it.toEventNeed() }
}

fun SponsorItem.toEventNeed(): EventNeedItem {
    return EventNeedItem(
        id = id ?: "",
        logo = logoUrl ?: "",
        title = name ?: "",
        label = listOf("Sponsor", field ?: ""),
        price = 0.0,
        rating = averageRating?.toDoubleOrNull() ?: 0.0,
        type = EventNeedItemType.SPONSOR
    )
}