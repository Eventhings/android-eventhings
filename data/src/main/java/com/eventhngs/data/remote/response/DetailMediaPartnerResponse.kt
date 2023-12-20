package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class DetailMediaPartnerResponse(

	@field:SerializedName("data")
	val data: DetailMediaPartnerData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class DetailMediaPartnerData(

	@field:SerializedName("whatsapp")
	val whatsapp: String? = null,

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("is_active")
	val isActive: Boolean? = null,

	@field:SerializedName("logo_url")
	val logoUrl: String? = null,

	@field:SerializedName("line")
	val line: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("instagram")
	val instagram: String? = null,

	@field:SerializedName("packages")
	val packages: List<PackagesItem>? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null,

	@field:SerializedName("approved_by")
	val approvedBy: String? = null,

	@field:SerializedName("twitter")
	val twitter: String? = null,

	@field:SerializedName("field")
	val field: String? = null,

	@field:SerializedName("is_archived")
	val isArchived: Boolean? = null,

	@field:SerializedName("reviews")
	val reviews: List<ReviewsItem>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("updated_by")
	val updatedBy: String? = null,

	@field:SerializedName("is_approved")
	val isApproved: Boolean? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class PackagesItem(

	@field:SerializedName("mp_id")
	val mpId: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class ReviewsItem(

	@field:SerializedName("mp_id")
	val mpId: String? = null,

	@field:SerializedName("user_detail")
	val userDetail: UserDetail? = null,

	@field:SerializedName("review")
	val review: String? = null,

	@field:SerializedName("rating")
	val rating: Int? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class UserDetail(
	@field:SerializedName("id")
	val id: String? = null,
	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("email")
	val email: String? = null,
)
