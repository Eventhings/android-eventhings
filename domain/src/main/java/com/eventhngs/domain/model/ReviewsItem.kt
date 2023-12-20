package com.eventhngs.domain.model

data class ReviewsItem(

    val mpId: String = "",

    val userDetail: UserDetail = UserDetail(),

    val review: String = "",

    val rating: Int = 0,

    val id: String = ""
)
