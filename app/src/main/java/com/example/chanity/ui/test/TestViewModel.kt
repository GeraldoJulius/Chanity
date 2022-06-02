package com.example.chanity.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {
    private val _answerList = MutableLiveData<String>("")
    val answerList: LiveData<String> = _answerList

    fun storeAnswer(allAnswer: String) {
        _answerList.value = allAnswer
    }

    /*override fun resetTest() {
        super.onCleared()
    }*/
}