package com.example.chanity.model


data class ChanityResponse(

	@field:SerializedName("result")
	val result: Result,

	@field:SerializedName("success")
	val success: Boolean
)

annotation class SerializedName(val value: String)

data class Result(

	@field:SerializedName("Conscientiousness")
	val conscientiousness: Int,

	@field:SerializedName("Neuroticism")
	val neuroticism: Int,

	@field:SerializedName("Openness")
	val openness: Int,

	@field:SerializedName("Extraversion")
	val extraversion: Int,

	@field:SerializedName("Agreeableness")
	val agreeableness: Int
)
