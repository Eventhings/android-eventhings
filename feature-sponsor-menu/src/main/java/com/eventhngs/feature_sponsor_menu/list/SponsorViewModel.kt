package com.eventhngs.feature_sponsor_menu.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsPagingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SponsorViewModel(
    private val eventhngsPagingUseCase: EventhngsPagingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SponsorUiState())
    val uiState: StateFlow<SponsorUiState> get() = _uiState

    fun updateQuery(query: String) {
        _uiState.update {
            it.copy(query = query)
        }
    }

    fun getSponsor() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(sponsors = eventhngsPagingUseCase.getSponsor())
            }
        }
    }

}