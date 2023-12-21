package com.eventhngs.feature_profile.editprofile

import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.model.User

data class EditProfileUiState(
    val user: Resource<User> = Resource.Idle,
    val updateUserResult: Resource<User> = Resource.Idle,
    val fullName: String = "",
    val email: String = "",
    val birthDate: String = "",
    val whatsapp: String = "",
    val domicile: String = "",
)
