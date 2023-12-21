package com.eventhngs.domain.model

data class UserPreference(
    val name: String = "",
    val email: String = "",
    val accessToken: String = "",
    val refreshToken: String = "",
)
