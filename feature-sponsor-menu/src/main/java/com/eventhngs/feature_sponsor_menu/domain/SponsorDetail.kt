package com.eventhngs.feature_sponsor_menu.domain

data class SponsorDetail(
    val id: String = "",
    val logoUrl: String = "",
    val name: String = "",
    val label: List<String> = emptyList(),
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val email: String = "",
    val website: String = "",
    val instagram: String = "",
    val whatsapp: String = "",
    val stepsToBook: List<String> = emptyList(),
    val stepsAfterBook: List<String> = emptyList(),
    val description: String = "",
    val value: List<String> = emptyList(),
    val reviewSentiment: String = ""
)
