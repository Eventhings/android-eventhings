package com.eventhngs.feature_equipment_rental_menu.detail

import com.eventhngs.domain.model.DetailEquipment
import com.eventhngs.domain.model.EventNeedItem
import com.eventhngs.domain.model.Resource

data class DetailEquipmentListUiState(
    val detailEquipmentList: Resource<List<EventNeedItem>> = Resource.Idle
)