package com.eventhngs.feature_media_partner_menu.domain

data class MediaPartnerDetail(
    val id: Int = 0,
    val logo: String = "",
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
    val about: String = "",
    val value: List<String> = emptyList(),
)
