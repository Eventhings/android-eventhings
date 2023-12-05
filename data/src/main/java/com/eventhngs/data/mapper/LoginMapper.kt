package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.LoginResponse
import com.eventhngs.domain.model.LoginResult

fun LoginResponse.toDomain(): LoginResult {
    return LoginResult(
        accessToken = data?.accessToken ?: "",
        refreshToken = data?.refreshToken ?: "",
        name = data?.name ?: "",
        email = data?.email ?: ""
    )
}