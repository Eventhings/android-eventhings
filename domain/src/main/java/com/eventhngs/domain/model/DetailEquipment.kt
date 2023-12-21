package com.eventhngs.domain.model

data class DetailEquipment(

    val whatsapp: String = "",

    val lastUpdated: String = "",

    val website: String = "",

    val isActive: Boolean = false,

    val logoUrl: String = "",

    val line: String = "",

    val description: String = "",

    val createdAt: String = "",

    val instagram: String = "",

    val packages: List<PackagesItem> = emptyList(),

    val createdBy: String = "",

    val approvedBy: String = "",

    val twitter: String = "",

    val field: String = "",

    val isArchived: Boolean = false,

    val reviews: List<ReviewsItem> = emptyList(),

    val name: String = "",

    val updatedBy: String = "",

    val isApproved: Boolean = false,

    val location: String = "",

    val id: String = "",

    val value: String = "",

    val email: String = "",

    val averageRating: Double,

    val reviewSentiment: String = ""
)
