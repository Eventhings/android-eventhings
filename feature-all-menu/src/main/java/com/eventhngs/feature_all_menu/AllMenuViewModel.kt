package com.eventhngs.feature_all_menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsPagingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AllMenuViewModel(
    private val eventhngsPagingUseCase: EventhngsPagingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AllMenuUiState())
    val uiState: StateFlow<AllMenuUiState> get() = _uiState

    fun updateQuery(query: String) {
        _uiState.update {
            it.copy(query = query)
        }
    }

    fun getEquipment() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(allMenus = eventhngsPagingUseCase.getAll())
            }
        }
    }

}