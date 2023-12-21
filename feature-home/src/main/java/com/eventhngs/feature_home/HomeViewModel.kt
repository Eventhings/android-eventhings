package com.eventhngs.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsUseCase
import com.eventhngs.domain.usecase.UserPreferenceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userPreferenceUseCase: UserPreferenceUseCase,
    private val eventhngsUseCase: EventhngsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    fun getUserPreference() {
        viewModelScope.launch {
            userPreferenceUseCase.userPreference.collect { userPreference ->
                _uiState.update {
                    it.copy(userPreference = userPreference)
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

    fun getRecommendations(accessToken: String) {
        viewModelScope.launch {
            eventhngsUseCase.getRecommendation(accessToken).collect { result ->
                _uiState.update {
                    it.copy(recommendations = result)
                }
            }
        }
    }

}