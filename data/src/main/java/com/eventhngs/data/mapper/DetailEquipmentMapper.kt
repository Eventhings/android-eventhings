package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.DetailEquipmentData
import com.eventhngs.domain.model.DetailEquipment

fun DetailEquipmentData.toDomain(): DetailEquipment {
    return DetailEquipment(
        whatsapp = whatsapp ?: "",
        lastUpdated = lastUpdated ?: "",
        website = website ?: "",
        isActive = isActive ?: false,
        logoUrl = logoUrl ?: "",
        line = line ?: "",
        description = description ?: "",
        createdAt = createdAt ?: "",
        instagram = instagram ?: "",
        packages = packages?.map { it.toDomain() } ?: emptyList(),
        createdBy = createdBy ?: "",
        approvedBy = approvedBy ?: "",
        twitter = twitter ?: "",
        field = field ?: "",
        isApproved = isApproved ?: false,
        isArchived = isArchived ?: false,
        reviews = reviews?.map { it.toDomain() } ?: emptyList(),
        name = name ?: "",
        updatedBy = updatedBy ?: "",
        location = location ?: "",
        id = id ?: "",
        value = value ?: "",
        email = email ?: "",
        averageRating = averageRating ?: 0.0,
        reviewSentiment = reviewSentiment ?: ""
    )
}
