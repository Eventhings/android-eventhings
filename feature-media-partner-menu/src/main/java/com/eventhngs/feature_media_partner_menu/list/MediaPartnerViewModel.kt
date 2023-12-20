package com.eventhngs.feature_media_partner_menu.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsPagingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MediaPartnerViewModel(
    private val eventhngsPagingUseCase: EventhngsPagingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MediaPartnerUiState())
    val uiState: StateFlow<MediaPartnerUiState> get() = _uiState

    fun updateQuery(query: String) {
        _uiState.update {
            it.copy(query = query)
        }
    }

    fun getMediaPartner() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(mediaPartners = eventhngsPagingUseCase.getMediaPartner())
            }
        }
    }

}