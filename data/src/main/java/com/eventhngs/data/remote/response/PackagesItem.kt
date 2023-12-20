package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class PackagesItem(

    @field:SerializedName("mp_id")
    val mpId: String? = null,

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: String? = null
)
