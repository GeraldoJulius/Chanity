package com.example.chanity.api

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("chanity")
    fun postQuiz(

    ): Call<QuizResponse>

}