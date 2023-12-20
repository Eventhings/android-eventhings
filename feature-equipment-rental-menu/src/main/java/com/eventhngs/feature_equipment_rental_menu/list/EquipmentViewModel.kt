package com.eventhngs.feature_equipment_rental_menu.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsPagingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EquipmentViewModel(
    private val eventhngsPagingUseCase: EventhngsPagingUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(EquipmentUiState())
    val uiState: StateFlow<EquipmentUiState> get() = _uiState

    fun updateQuery(query: String) {
        _uiState.update {
            it.copy(query = query)
        }
    }

    fun getEquipment() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(equipments = eventhngsPagingUseCase.getEquipment())
            }
        }
    }

}