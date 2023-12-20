package com.eventhngs.data.mapper

import com.eventhngs.data.remote.response.DetailMediaPartnerData
import com.eventhngs.domain.model.DetailMediaPartner
import com.eventhngs.domain.model.PackagesItem
import com.eventhngs.data.remote.response.PackagesItem as PackagesItemResponse
import com.eventhngs.domain.model.ReviewsItem
import com.eventhngs.data.remote.response.ReviewsItem as ReviewsItemResponse
import com.eventhngs.domain.model.UserDetail
import com.eventhngs.data.remote.response.UserDetail as UserDetailResponse

fun DetailMediaPartnerData.toDomain(): DetailMediaPartner {
    return DetailMediaPartner(
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
        email = email ?: ""
    )
}

fun PackagesItemResponse.toDomain(): PackagesItem {
    return PackagesItem(
        mpId = mpId ?: "",
        price = price ?: 0.0,
        name = name ?: "",
        description = description ?: "",
        id = id ?: ""
    )
}

fun ReviewsItemResponse.toDomain(): ReviewsItem {
    return ReviewsItem(
        mpId = id ?: "",
        userDetail = userDetail?.toDomain() ?: UserDetail(),
        review = review ?: "",
        rating = rating ?: 0,
        id = id ?: ""
    )
}

fun UserDetailResponse.toDomain(): UserDetail {
    return UserDetail(
        id = id ?: "",
        name = name ?: "",
        email = email ?: ""
    )
}
