package com.eventhngs.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val eventhngsUseCase: EventhngsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState

    fun getRecommendations() {
        viewModelScope.launch {
            eventhngsUseCase.getRecommendation().collect { result ->
                _uiState.update {
                    it.copy(recommendations = result)
                }
            }
        }
    }

}