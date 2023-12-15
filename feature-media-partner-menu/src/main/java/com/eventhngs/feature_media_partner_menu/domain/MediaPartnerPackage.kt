package com.eventhngs.feature_media_partner_menu.domain

data class MediaPartnerPackage(
    val id: Int = 0,
    val name: String = "",
    val benefits: List<String> = emptyList(),
    val price: Double = 0.0,
    val quantity: Int = 0,
)
