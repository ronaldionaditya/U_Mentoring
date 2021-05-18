package com.mobile.umentoring.model

import com.google.gson.annotations.SerializedName

data class ResponsePortofolio(

	@field:SerializedName("data")
	val data: List<DataItemPortofolio?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class Participant(

	@field:SerializedName("sekolah")
	val sekolah: String? = null,

	@field:SerializedName("image")
	val image: Any? = null,

	@field:SerializedName("no_tlp")
	val noTlp: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("angkatan")
	val angkatan: String? = null,

	@field:SerializedName("program_id")
	val programId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class DataItemPortofolio(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("participants_id")
	val participantsId: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("participant")
	val participant: Participant
)
