package com.eventhngs.data.remote.response

import com.google.gson.annotations.SerializedName

data class AllResponse(

	@field:SerializedName("data")
	val data: AllData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class AllData(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: List<AllItem>? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("total_page")
	val totalPage: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null
)

data class AllItem(

	@field:SerializedName("service_type")
	val serviceType: String? = null,

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

	@field:SerializedName("average_rating")
	val averageRating: String? = null,

	@field:SerializedName("instagram")
	val instagram: String? = null,

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

	@field:SerializedName("min_price")
	val minPrice: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("updated_by")
	val updatedBy: String? = null,

	@field:SerializedName("is_approved")
	val isApproved: Boolean? = null,

	@field:SerializedName("location")
	val location: Any? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
