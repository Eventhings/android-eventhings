package com.eventhngs.feature_sponsor_menu.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailSponsorViewModel(
    private val eventhngsUseCase: EventhngsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailSponsorUiState())
    val uiState: StateFlow<DetailSponsorUiState> get() = _uiState

    fun getDetailSponsor(id: String) {
        viewModelScope.launch {
            eventhngsUseCase.getSponsorById(id).collect { result ->
                _uiState.update {
                    it.copy(detailSponsor = result)
                }
            }
        }
    }

}