package com.eventhngs.feature_sponsor_menu.mapper

import com.eventhngs.domain.model.DetailSponsor
import com.eventhngs.feature_sponsor_menu.domain.SponsorDetail

fun DetailSponsor.toUi(): SponsorDetail {
    val label = listOf("Sponsor", field)
    val stepsToBook = listOf(
            "Go to our website",
            "Fill the sponsorship data",
            "Regularly check email for the further information regarding the agreement (max. 2 weeks)",
            "Send MOU"
        )
    val stepsAfterBook = listOf("Wait for the upload schedule and stay tune at our social media")
    val values = value.split("\n")
    return SponsorDetail(
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
