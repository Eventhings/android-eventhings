package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("data")
	val data: UserData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class UserData(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("dob")
	val dob: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("phone_number")
	val phoneNumber: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("photo_url")
	val photoUrl: String? = null,

	@field:SerializedName("display_name")
	val displayName: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("last_sign_in")
	val lastSignIn: String? = null
)
