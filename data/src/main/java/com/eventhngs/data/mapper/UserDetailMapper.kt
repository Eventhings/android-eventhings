package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.UserDetail

fun UserDetail.toDomain(): com.eventhngs.domain.model.UserDetail {
    return com.eventhngs.domain.model.UserDetail(
        id = id ?: "",
        name = name ?: "",
        email = email ?: ""
    )
}
