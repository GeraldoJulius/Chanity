package com.example.chanity.model

import com.google.gson.annotations.SerializedName

data class QuizResponse(

	@field:SerializedName("result")
	val result: QuizResult? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)

data class QuizResult(

	@field:SerializedName("Conscientiousness")
	val conscientiousness: Int? = null,

	@field:SerializedName("Neuroticism")
	val neuroticism: Int? = null,

	@field:SerializedName("Openness")
	val openness: Int? = null,

	@field:SerializedName("Extraversion")
	val extraversion: Int? = null,

	@field:SerializedName("Agreeableness")
	val agreeableness: Int? = null
)
