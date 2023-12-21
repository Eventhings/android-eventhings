package com.eventhngs.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsPreferenceRepository {

    val isLogging: Flow<Boolean>

    suspend fun setLoggingState(state: Boolean)

}