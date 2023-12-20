package com.eventhngs.feature_equipment_rental_menu.mapper

import com.eventhngs.domain.model.DetailEquipment
import com.eventhngs.feature_equipment_rental_menu.domain.EquipmentDetail

fun DetailEquipment.toUi(): EquipmentDetail {
    val label = listOf("Media Partner", field)
    val stepsToBook = listOf(
            "Choose package",
            "Add quantity",
            "Invoice and payment",
            "Send poster and caption"
        )
    val stepsAfterBook = listOf("Wait for the upload schedule and stay tune at our social media")
    val values = value.split("\n")
    return EquipmentDetail(
        id = id,
        logoUrl = logoUrl,
        name = name,
        label = label,
        price = 0.0,
        rating = 0.0,
        email = email,
        website = website,
        instagram = instagram,
        whatsapp = whatsapp,
        stepsToBook = stepsToBook,
        stepsAfterBook = stepsAfterBook,
        description = description,
        value = values
    )
}
