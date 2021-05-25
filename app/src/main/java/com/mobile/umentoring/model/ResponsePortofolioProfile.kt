package com.mobile.umentoring.model

import com.google.gson.annotations.SerializedName

data class ResponsePortofolioProfile(

	@field:SerializedName("data")
	val data: List<DataItemPortofolioProfile?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItemPortofolioProfile(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("participants_id")
	val participantsId: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
