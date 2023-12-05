package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.RegisterResponse
import com.eventhngs.domain.model.RegisterResult

fun RegisterResponse.toDomain(): RegisterResult {
    return RegisterResult(
        email = data?.email ?: ""
    )
}