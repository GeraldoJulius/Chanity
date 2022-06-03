package com.example.chanity.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.common.internal.FallbackServiceBroker

class TestViewModel: ViewModel() {
    private lateinit var questions: MutableList<String>

    private var isVeryInaccurate = false
    private var isInaccurate = false
    private var isNeutral = false
    private var isAccurate = false
    private var isVeryAccurate = false

    var testDegree = 0

    var index = 0

    private val _questionIndex = MutableLiveData<Int>()
    val questionIndex: LiveData<Int>
        get() = _questionIndex

    var questionNumber = 0
    private val _currentQuestion = MutableLiveData<String>()
    val currentQuestion: LiveData<String>
        get() = _currentQuestion

    private val _navigateToResult = MutableLiveData<Boolean>()
    val navigateToResult: LiveData<Boolean>
        get() = _navigateToResult

    init {
        isVeryInaccurate = false
        isInaccurate = false
        isNeutral = false
        isAccurate = false
        isVeryAccurate = false

        setAllQuestion()

        _currentQuestion.value = questions[index]
        _questionIndex.value = ++questionNumber
    }

    private fun setAllQuestion() {
        questions = mutableListOf(
            "I am the life of the party.",
            "I feel little concern for others.",
            "I am always prepared.",
            "I get stressed out easily.",
            "I have a rich vocabulary.",
            "I dont talk a lot.",
            "I am interested in people.",
            "I leave my belongings around.",
            "I am relaxed most of the time.",
            "I have a difficulty understanding abstract ideas.",
            "I feel comfortable around people.",
            "I insult people.",
            "I pay attention to details.",
            "I worry about things.",
            "I have a vivid imagination.",
            "I keep in the background.",
            "I sympathize with others feeling.",
            "I make a mess of things.",
            "I seldom feel blue.",
            "I am not interested in abstract ideas.",
            "I start conversations.",
            "I am not interested in other peoples problems.",
            "I get chores done right away.",
            "I am easily disturbed.",
            "I have excellent ideas.",
            "I have little to say.",
            "I have a soft heart.",
            "I often forget to put things back in their proper place.",
            "I get upset easily.",
            "I do not have a good imagination.",
            "I talk to a lot of different people at parties.",
            "I am not really interested in others.",
            "I like order.",
            "I change my mood a lot.",
            "I am quick to understand things.",
            "I dont like to draw attention to myself",
            "I take time out for others.",
            "I shirk my duties.",
            "I have frequent mood swings.",
            "I use difficult words.",
            "I dont mind being the center of attention.",
            "I feel others emotions.",
            "I follow a schedule.",
            "I get irritated easily.",
            "I spend time reflecting on things.",
            "I am quiet around strangers.",
            "I make people feel at ease.",
            "I am exacting in my work.",
            "I often feel blue.",
            "I am full of ideas."
        )
    }

    fun nextQuestion() {
        if (index < questions.size - 1 && (isVeryInaccurate || isInaccurate || isNeutral || isAccurate || isVeryAccurate)) {
            if (isAccurate || isVeryAccurate) {
                ++testDegree
            }
            _questionIndex.value = ++questionNumber
            _currentQuestion.value = questions[++index]
        } else if (index == questions.size - 1 && (isVeryInaccurate || isInaccurate || isNeutral || isAccurate || isVeryAccurate)) {
            if (isAccurate || isVeryAccurate) {
                ++testDegree

            }
            onNavigateToResult()

        }
        isVeryInaccurate = false
        isInaccurate = false
        isNeutral = false
        isAccurate = false
        isVeryAccurate = false
    }

    fun getVeryInaccurate() {
        if(isInaccurate || isNeutral || isAccurate || isVeryAccurate) {
            isInaccurate = false
            isNeutral = false
            isAccurate = false
            isVeryAccurate = false
        }
        isVeryInaccurate = true
    }

    fun getInaccurate() {
        if(isVeryInaccurate || isNeutral || isAccurate || isVeryAccurate) {
            isVeryInaccurate = false
            isNeutral = false
            isAccurate = false
            isVeryAccurate = false
        }
        isInaccurate = true
    }

    fun getNeutral() {
        if(isVeryInaccurate || isInaccurate || isAccurate || isVeryAccurate) {
            isVeryInaccurate = false
            isInaccurate = false
            isAccurate = false
            isVeryAccurate = false
        }
        isNeutral = true
    }

    fun getAccurate() {
        if(isVeryInaccurate || isInaccurate || isNeutral || isVeryAccurate) {
            isVeryInaccurate = false
            isInaccurate = false
            isNeutral = false
            isVeryAccurate = false
        }
        isAccurate = true
    }

    fun getVeryAccurate() {
        if(isVeryInaccurate || isInaccurate || isNeutral || isAccurate) {
            isVeryInaccurate = false
            isInaccurate = false
            isNeutral = false
            isAccurate = false
        }
        isVeryAccurate = true
    }

    fun onNavigateToResult() {
        _navigateToResult.value = true
    }

    fun onNavigateToResultComplete() {
        _navigateToResult.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}