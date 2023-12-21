package com.eventhngs.domain.interactor

import com.eventhngs.domain.model.UserPreference
import com.eventhngs.domain.repository.UserPreferenceRepository
import com.eventhngs.domain.usecase.UserPreferenceUseCase
import kotlinx.coroutines.flow.Flow

class UserPreferenceInteractor(
    private val userPreferenceRepository: UserPreferenceRepository
) : UserPreferenceUseCase {

    override val userPreference: Flow<UserPreference>
        get() = userPreferenceRepository.userPreference

    override suspend fun updateUserPreference(userPreference: UserPreference) {
        userPreferenceRepository.updateUserPreference(userPreference)
    }

    override suspend fun updateAccessToken(accessToken: String) {
        userPreferenceRepository.updateAccessToken(accessToken)
    }
}