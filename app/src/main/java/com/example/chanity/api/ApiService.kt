package com.example.chanity.api

import com.example.chanity.model.QuizResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("chanity")
    fun postQuiz(

    ): Call<QuizResponse>

}