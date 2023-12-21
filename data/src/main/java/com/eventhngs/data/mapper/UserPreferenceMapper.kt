package com.eventhngs.data.mapper

import com.eventhngs.domain.model.UserPreference
import com.eventhngs.data.UserPreference as UserPreferenceSetting

fun UserPreferenceSetting.toDomain(): UserPreference {
    return UserPreference(
        name = name,
        email = email,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}