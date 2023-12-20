package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class ReviewsItem(

    @field:SerializedName("mp_id")
    val mpId: String? = null,

    @field:SerializedName("user_detail")
    val userDetail: UserDetail? = null,

    @field:SerializedName("review")
    val review: String? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("id")
    val id: String? = null
)
