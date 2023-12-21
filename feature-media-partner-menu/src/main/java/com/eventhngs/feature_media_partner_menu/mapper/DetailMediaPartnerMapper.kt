package com.eventhngs.feature_media_partner_menu.mapper

import com.eventhngs.domain.model.DetailMediaPartner
import com.eventhngs.feature_media_partner_menu.domain.MediaPartnerDetail

fun DetailMediaPartner.toUi(): MediaPartnerDetail {
    val label = listOf("Media Partner", field)
    val stepsToBook = listOf(
            "Choose package",
            "Add quantity",
            "Invoice and payment",
            "Send poster and caption"
        )
    val stepsAfterBook = listOf("Wait for the upload schedule and stay tune at our social media")
    val values = value.split("\n")
    return MediaPartnerDetail(
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
        value = values,
        reviewSentiment = reviewSentiment
    )
}
