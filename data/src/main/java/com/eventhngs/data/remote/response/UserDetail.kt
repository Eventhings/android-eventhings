package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserDetail(
    @field:SerializedName("id")
    val id: String? = null,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("email")
    val email: String? = null,
)
