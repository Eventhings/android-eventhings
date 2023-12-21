package com.eventhngs.domain.usecase

import com.eventhngs.domain.repository.SettingsPreferenceRepository
import kotlinx.coroutines.flow.Flow

class SettingsPreferenceInteractor(
    private val repository: SettingsPreferenceRepository
) : SettingsPreferenceUseCase {
    override val isLogging: Flow<Boolean> get() = repository.isLogging

    override suspend fun setLoggingState(state: Boolean) {
        repository.setLoggingState(state)
    }
}