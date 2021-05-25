package com.mobile.umentoring.model

import com.google.gson.annotations.SerializedName

data class ResponseProgramProfile(

	@field:SerializedName("data")
	val data: List<DataItemProgramProfile?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class Program(

	@field:SerializedName("nama_program")
	val namaProgram: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("program_image")
	val programImage: String? = null
)

data class DataItemProgramProfile(

	@field:SerializedName("sekolah")
	val sekolah: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

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

	@field:SerializedName("program")
	val program: Program? = null,

	@field:SerializedName("email")
	val email: String? = null
)
