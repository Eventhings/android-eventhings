package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(

	@field:SerializedName("data")
	val data: RefreshTokenData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class RefreshTokenData(

	@field:SerializedName("access_token")
	val accessToken: String? = null
)
