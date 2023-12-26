package com.eventhngs.feature_equipment_rental_menu.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventhngs.domain.usecase.EventhngsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailEquipmentViewModel(
    private val eventhngsUseCase: EventhngsUseCase
) : ViewModel() {

    private val _uiStateList = MutableStateFlow(DetailEquipmentListUiState())
    private val _uiState = MutableStateFlow(DetailEquipmentUiState())
    val uiState: StateFlow<DetailEquipmentUiState> get() = _uiState

    fun getDetailEquipment(id: String) {
        viewModelScope.launch {
            eventhngsUseCase.getEquipmentById(id).collect { result ->
                _uiState.update {
                    it.copy(detailEquipment = result)
                }
            }
        }
    }

    fun getRecommendationEquipment(token: String, id: String){
        viewModelScope.launch {
            eventhngsUseCase.getRecommendationEquipment(token, id).collect { result ->

                _uiStateList.update {
                    it.copy(detailEquipmentList = result)
                }
            }
        }
    }

}