package com.eventhngs.feature_profile.profile

import com.eventhngs.domain.model.RefreshToken
import com.eventhngs.domain.model.Resource
import com.eventhngs.domain.model.User
import com.eventhngs.domain.model.UserPreference

data class ProfileUiState(
    val userPreference: UserPreference = UserPreference(),
    val refreshToken: Resource<RefreshToken> = Resource.Idle,
    val user: Resource<User> = Resource.Idle
)
