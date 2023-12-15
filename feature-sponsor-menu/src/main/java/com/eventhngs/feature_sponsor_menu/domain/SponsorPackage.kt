package com.eventhngs.feature_sponsor_menu.domain

data class SponsorPackage(
    val id: Int = 0,
    val name: String = "",
    val benefits: List<String> = emptyList(),
    val price: Double = 0.0,
    val quantity: Int = 0,
)
