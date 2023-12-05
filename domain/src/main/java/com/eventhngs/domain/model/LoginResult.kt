package com.eventhngs.domain.model

data class LoginResult(

	val accessToken: String = "",

	val refreshToken: String = "",

	val name: String = "",

	val email: String = ""
)
