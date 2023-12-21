package com.eventhngs.data

import androidx.datastore.core.DataStore
import com.eventhngs.data.mapper.toDomain
import com.eventhngs.domain.model.UserPreference
import com.eventhngs.domain.repository.UserPreferenceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferenceRepositoryImpl(
    private val userPreferenceSetting: DataStore<com.eventhngs.data.UserPreference>
) : UserPreferenceRepository {

    override val userPreference: Flow<UserPreference>
        get() = userPreferenceSetting.data.map { userPreference ->
            userPreference.toDomain()
        }

    override suspend fun updateUserPreference(userPreference: UserPreference) {
        userPreferenceSetting.updateData { preference ->
            preference.toBuilder()
                .setName(userPreference.name)
                .setEmail(userPreference.email)
                .setAccessToken(userPreference.accessToken)
                .setRefreshToken(userPreference.refreshToken)
                .build()
        }
    }

    override suspend fun updateAccessToken(accessToken: String) {
        userPreferenceSetting.updateData { preference ->
            preference.toBuilder()
                .setAccessToken(accessToken)
                .build()
        }
    }
}