package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.RefreshTokenData
import com.eventhngs.domain.model.RefreshToken

fun RefreshTokenData.toDomain(): RefreshToken {
    return RefreshToken(
        accessToken = accessToken ?: ""
    )
}