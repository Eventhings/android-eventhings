package com.eventhngs.feature_profile.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsUseCase
import com.eventhngs.domain.usecase.UserPreferenceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val eventhngsUseCase: EventhngsUseCase,
    private val userPreferenceUseCase: UserPreferenceUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> get() = _uiState

    fun getUserPreference() {
        viewModelScope.launch {
            userPreferenceUseCase.userPreference.collect { result ->
                _uiState.update {
                    it.copy(userPreference = result)
                }
            }
        }
    }

    fun getRefreshToken(refreshToken: String) {
        viewModelScope.launch {
            eventhngsUseCase.refreshToken(refreshToken).collect { result ->
                _uiState.update {
                    it.copy(refreshToken = result)
                }
            }
        }
    }

    fun getUserLogging(accessToken: String) {
        viewModelScope.launch {
            eventhngsUseCase.getUserLogging(accessToken).collect { result ->
                _uiState.update {
                    it.copy(user = result)
                }
            }
        }
    }

    fun updateAccessToken(accessToken: String) {
         viewModelScope.launch {
             userPreferenceUseCase.updateAccessToken(accessToken)
         }
    }

}