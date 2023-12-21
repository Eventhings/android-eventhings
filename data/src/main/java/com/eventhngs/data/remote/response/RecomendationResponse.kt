package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class RecomendationResponse(

    @field:SerializedName("data")
    val data: List<AllItem>? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Int? = null
)