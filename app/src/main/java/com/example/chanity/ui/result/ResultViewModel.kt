package com.example.chanity.ui.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chanity.api.ApiConfig
import com.example.chanity.model.QuizResponse
import com.example.chanity.model.QuizResult
import com.example.chanity.ui.test.TestActivity2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultViewModel : ViewModel() {
        private val _quizResponse = MutableLiveData<QuizResult>()
        val quizResponse: LiveData<QuizResult> = _quizResponse

        private val _isLoading = MutableLiveData<Boolean>()
        val isLoading: LiveData<Boolean> = _isLoading

        fun postQuiz() {
            _isLoading.value = true
            val client = ApiConfig.getApiService().postQuiz()
            client.enqueue(object : Callback<QuizResponse> {
                override fun onResponse(
                    call: Call<QuizResponse>,
                    response: Response<QuizResponse>
                ) {
                    if (response.isSuccessful) {
                        _isLoading.value = false
                        _quizResponse.value = response.body()?.result!!
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<QuizResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${ t.message.toString() }")
                }
            })
        }

        companion object {
            private const val TAG = "ResultViewModel"
        }
    }