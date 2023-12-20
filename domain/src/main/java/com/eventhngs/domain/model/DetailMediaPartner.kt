package com.eventhngs.domain.model

data class DetailMediaPartner(

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

	val email: String = ""
)

data class PackagesItem(

	val mpId: String = "",

	val price: Double = 0.0,

	val name: String = "",

	val description: String = "",

	val id: String = ""
)

data class ReviewsItem(

	val mpId: String = "",

	val userDetail: UserDetail = UserDetail(),

	val review: String = "",

	val rating: Int = 0,

	val id: String = ""
)

data class UserDetail(

	val id: String = "",

	val name: String = "",

	val email: String = "",
)
