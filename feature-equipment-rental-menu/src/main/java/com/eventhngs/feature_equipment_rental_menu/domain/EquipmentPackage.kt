package com.eventhngs.feature_equipment_rental_menu.domain

data class EquipmentPackage(
    val id: String = "",
    val name: String = "",
    val benefits: List<String> = emptyList(),
    val price: Double = 0.0,
    val quantity: Int = 0,
)
