package com.eventhngs.feature_home.domain

data class CarouselItem(
    val id: Int = 0,
    val logo: String = "",
    val title: String = "",
    val label: String = "",
    val price: Double = 0.0,
    val rating: Double = 0.0,
)
