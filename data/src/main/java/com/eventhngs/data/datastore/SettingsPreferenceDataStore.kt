package com.eventhngs.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsPreferenceDataStore(
    private val context: Context
) {

    private val dataStore get() = context.dataStore

    companion object {
        val isLoggingKey = booleanPreferencesKey("is_logging")
    }

    val isLogging: Flow<Boolean> get() = dataStore.data.map { preferences ->
        preferences[isLoggingKey] ?: false
    }

    suspend fun setLoggingState(state: Boolean) {
        dataStore.edit { preferences ->
            preferences[isLoggingKey] = state
        }
    }

}