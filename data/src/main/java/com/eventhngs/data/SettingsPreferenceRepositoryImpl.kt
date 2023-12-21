package com.eventhngs.data

import com.eventhngs.data.datastore.SettingsPreferenceDataStore
import com.eventhngs.domain.repository.SettingsPreferenceRepository
import kotlinx.coroutines.flow.Flow

class SettingsPreferenceRepositoryImpl(
    private val settingsPreferenceDataStore: SettingsPreferenceDataStore
) : SettingsPreferenceRepository {

    override val isLogging: Flow<Boolean> get() = settingsPreferenceDataStore.isLogging

    override suspend fun setLoggingState(state: Boolean) {
        settingsPreferenceDataStore.setLoggingState(state)
    }

}