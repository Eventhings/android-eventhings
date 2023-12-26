package com.eventhngs.feature_equipment_rental_menu.detail

import com.eventhngs.domain.model.DetailEquipment
import com.eventhngs.domain.model.Resource

data class DetailEquipmentUiState(
    val detailEquipment: Resource<DetailEquipment> = Resource.Idle,
    val detailEquipmentList: Resource<List<DetailEquipment>> = Resource.Idle
)
