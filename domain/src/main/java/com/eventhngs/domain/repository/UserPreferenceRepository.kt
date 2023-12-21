package com.eventhngs.domain.repository

import com.eventhngs.domain.model.UserPreference
import kotlinx.coroutines.flow.Flow

interface UserPreferenceRepository {

    val userPreference: Flow<UserPreference>

    suspend fun updateUserPreference(userPreference: UserPreference)

    suspend fun updateAccessToken(accessToken: String)

}