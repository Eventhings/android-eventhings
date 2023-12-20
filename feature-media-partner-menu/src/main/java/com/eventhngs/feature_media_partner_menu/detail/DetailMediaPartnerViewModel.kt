package com.eventhngs.feature_media_partner_menu.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailMediaPartnerViewModel(
    private val eventhngsUseCase: EventhngsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailMediaPartnerUiState())
    val uiState: StateFlow<DetailMediaPartnerUiState> get() = _uiState

    fun getDetailMediaPartner(id: String) {
        viewModelScope.launch {
            eventhngsUseCase.getMediaPartnerById(id).collect { result ->
                _uiState.update {
                    it.copy(detailMediaPartner = result)
                }
            }
        }
    }

}