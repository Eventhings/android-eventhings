package com.eventhngs.feature_equipment_rental_menu.list

import androidx.paging.PagingData
import com.eventhngs.domain.model.EventNeedItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class EquipmentUiState(
    val query: String = "",
    val equipments: Flow<PagingData<EventNeedItem>> = flowOf()
)
