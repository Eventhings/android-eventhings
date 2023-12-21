package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.UserData
import com.eventhngs.domain.model.User

fun UserData.toDomain(): User {
    return User(
        role = role ?: "",
        dob = dob ?: "",
        createdAt = createdAt ?: "",
        phoneNumber = phoneNumber ?: "",
        location = location ?: "",
        id = id ?: "",
        photoUrl = photoUrl ?: "",
        displayName = displayName ?: "",
        email = email ?: "",
        lastSignIn = lastSignIn ?: ""
    )
}