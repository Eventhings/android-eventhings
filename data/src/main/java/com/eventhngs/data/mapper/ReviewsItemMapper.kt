package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.ReviewsItem
import com.eventhngs.domain.model.UserDetail

fun ReviewsItem.toDomain(): com.eventhngs.domain.model.ReviewsItem {
    return com.eventhngs.domain.model.ReviewsItem(
        mpId = id ?: "",
        userDetail = userDetail?.toDomain() ?: UserDetail(),
        review = review ?: "",
        rating = rating ?: 0,
        id = id ?: ""
    )
}
