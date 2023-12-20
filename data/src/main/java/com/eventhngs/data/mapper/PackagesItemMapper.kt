package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.PackagesItem

fun PackagesItem.toDomain(): com.eventhngs.domain.model.PackagesItem {
    return com.eventhngs.domain.model.PackagesItem(
        mpId = mpId ?: "",
        price = price ?: 0.0,
        name = name ?: "",
        description = description ?: "",
        id = id ?: ""
    )
}