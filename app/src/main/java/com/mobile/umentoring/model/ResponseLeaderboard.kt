package com.mobile.umentoring.model

import com.google.gson.annotations.SerializedName

data class ResponseLeaderboard(

	@field:SerializedName("data")
	val data: List<DataItemLeaderboad?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItemLeaderboad(

	@field:SerializedName("submission_19")
	val submission19: Any? = null,

	@field:SerializedName("submission_18")
	val submission18: Any? = null,

	@field:SerializedName("submission_17")
	val submission17: Any? = null,

	@field:SerializedName("submission_16")
	val submission16: Any? = null,

	@field:SerializedName("submission_15")
	val submission15: Any? = null,

	@field:SerializedName("submission_14")
	val submission14: Any? = null,

	@field:SerializedName("submission_13")
	val submission13: Any? = null,

	@field:SerializedName("submission_12")
	val submission12: Int? = null,

	@field:SerializedName("submission_11")
	val submission11: Int? = null,

	@field:SerializedName("submission_10")
	val submission10: Int? = null,

	@field:SerializedName("participant")
	val participant: ParticipantLeaderboard? = null,

	@field:SerializedName("submission_7")
	val submission7: Int? = null,

	@field:SerializedName("submission_8")
	val submission8: Int? = null,

	@field:SerializedName("submission_9")
	val submission9: Any? = null,

	@field:SerializedName("submission_3")
	val submission3: Any? = null,

	@field:SerializedName("submission_4")
	val submission4: Int? = null,

	@field:SerializedName("submission_5")
	val submission5: Int? = null,

	@field:SerializedName("submission_6")
	val submission6: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("exam_10")
	val exam10: Any? = null,

	@field:SerializedName("exam_2")
	val exam2: Int? = null,

	@field:SerializedName("exam_3")
	val exam3: Int? = null,

	@field:SerializedName("exam_1")
	val exam1: Int? = null,

	@field:SerializedName("exam_6")
	val exam6: Any? = null,

	@field:SerializedName("exam_7")
	val exam7: Any? = null,

	@field:SerializedName("exam_4")
	val exam4: Int? = null,

	@field:SerializedName("exam_5")
	val exam5: Any? = null,

	@field:SerializedName("exam_8")
	val exam8: Any? = null,

	@field:SerializedName("exam_9")
	val exam9: Any? = null,

	@field:SerializedName("participant_id")
	val participantId: Int? = null,

	@field:SerializedName("program_id")
	val programId: Any? = null,

	@field:SerializedName("submission_36")
	val submission36: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("submission_35")
	val submission35: Any? = null,

	@field:SerializedName("submission_34")
	val submission34: Any? = null,

	@field:SerializedName("submission_33")
	val submission33: Any? = null,

	@field:SerializedName("submission_32")
	val submission32: Any? = null,

	@field:SerializedName("submission_31")
	val submission31: Any? = null,

	@field:SerializedName("submission_30")
	val submission30: Any? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("exam_11")
	val exam11: Any? = null,

	@field:SerializedName("submission_29")
	val submission29: Any? = null,

	@field:SerializedName("exam_12")
	val exam12: Any? = null,

	@field:SerializedName("submission_28")
	val submission28: Any? = null,

	@field:SerializedName("submission_27")
	val submission27: Any? = null,

	@field:SerializedName("submission_26")
	val submission26: Any? = null,

	@field:SerializedName("submission_25")
	val submission25: Any? = null,

	@field:SerializedName("submission_1")
	val submission1: Int? = null,

	@field:SerializedName("submission_24")
	val submission24: Any? = null,

	@field:SerializedName("submission_2")
	val submission2: Any? = null,

	@field:SerializedName("submission_23")
	val submission23: Any? = null,

	@field:SerializedName("submission_22")
	val submission22: Any? = null,

	@field:SerializedName("submission_21")
	val submission21: Any? = null,

	@field:SerializedName("submission_20")
	val submission20: Any? = null
)

data class ParticipantLeaderboard(

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
