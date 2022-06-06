package com.example.chanity.ui.test

import android.widget.Toast
import androidx.core.util.rangeTo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chanity.R

class TestViewModel: ViewModel() {
    private lateinit var questions: MutableList<String>

    private var isVeryInaccurate = false
    private var isInaccurate = false
    private var isNeutral = false
    private var isAccurate = false
    private var isVeryAccurate = false

    var testDegree = 0

    private var testDegreeOpn = 0
    private var testDegreeCon = 0
    private var testDegreeExt = 0
    private var testDegreeAgr = 0
    private var testDegreeNeu = 0

    private var index = 0
    private val _questionIndex = MutableLiveData<Int>()
    val questionIndex: LiveData<Int>
        get() = _questionIndex

    private var questionNumber = 0
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
            // EXT
            "I am the life of the party.",
            "I dont talk a lot.",
            "I feel comfortable around people.",
            "I keep in the background.",
            "I start conversations.",
            "I have little to say.",
            "I talk to a lot of different people at parties.",
            "I dont like to draw attention to myself",
            "I dont mind being the center of attention.",
            "I am quiet around strangers.",
            // EST
            "I get stressed out easily.",
            "I am relaxed most of the time.",
            "I worry about things.",
            "I seldom feel blue.",
            "I am easily disturbed.",
            "I get upset easily.",
            "I change my mood a lot.",
            "I have frequent mood swings.",
            "I get irritated easily.",
            "I often feel blue.",
            // AGR
            "I feel little concern for others.",
            "I am interested in people.",
            "I insult people.",
            "I sympathize with others feeling.",
            "I am not interested in other peoples problems.",
            "I have a soft heart.",
            "I am not really interested in others.",
            "I take time out for others.",
            "I feel others emotions.",
            "I make people feel at ease.",
            // CSN
            "I am always prepared.",
            "I leave my belongings around.",
            "I pay attention to details.",
            "I make a mess of things.",
            "I get chores done right away.",
            "I often forget to put things back in their proper place.",
            "I like order.",
            "I shirk my duties.",
            "I follow a schedule.",
            "I am exacting in my work.",
            // OPN
            "I have a rich vocabulary.",
            "I have a difficulty understanding abstract ideas.",
            "I have a vivid imagination.",
            "I am not interested in abstract ideas.",
            "I have excellent ideas.",
            "I do not have a good imagination.",
            "I am quick to understand things.",
            "I use difficult words.",
            "I spend time reflecting on things.",
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
        if (isInaccurate || isNeutral || isAccurate || isVeryAccurate) {
            isInaccurate = false
            isNeutral = false
            isAccurate = false
            isVeryAccurate = false
        }
        isVeryInaccurate = true

        when (questionNumber) {
            in 1..10 -> {
                testDegreeExt += 1
            }
            in 11..20 -> {
                testDegreeNeu += 1
            }
            in 21..30 -> {
                testDegreeAgr += 1
            }
            in 31..40 -> {
                testDegreeCon += 1
            }
            in 41..50 -> {
                testDegreeOpn += 1
            }
        }
    }

    fun getInaccurate() {
        if (isVeryInaccurate || isNeutral || isAccurate || isVeryAccurate) {
            isVeryInaccurate = false
            isNeutral = false
            isAccurate = false
            isVeryAccurate = false
        }
        isInaccurate = true

        when (questionNumber) {
            in 1..10 -> {
                testDegreeExt += 2
            }
            in 11..20 -> {
                testDegreeNeu += 2
            }
            in 21..30 -> {
                testDegreeAgr += 2
            }
            in 31..40 -> {
                testDegreeCon += 2
            }
            in 41..50 -> {
                testDegreeOpn += 2
            }
        }
    }

    fun getNeutral() {
        if (isVeryInaccurate || isInaccurate || isAccurate || isVeryAccurate) {
            isVeryInaccurate = false
            isInaccurate = false
            isAccurate = false
            isVeryAccurate = false
        }
        isNeutral = true

        when (questionNumber) {
            in 1..10 -> {
                testDegreeExt += 3
            }
            in 11..20 -> {
                testDegreeNeu += 3
            }
            in 21..30 -> {
                testDegreeAgr += 3
            }
            in 31..40 -> {
                testDegreeCon += 3
            }
            in 41..50 -> {
                testDegreeOpn += 3
            }
        }
    }

    fun getAccurate() {
        if (isVeryInaccurate || isInaccurate || isNeutral || isVeryAccurate) {
            isVeryInaccurate = false
            isInaccurate = false
            isNeutral = false
            isVeryAccurate = false
        }
        isAccurate = true

        when (questionNumber) {
            in 1..10 -> {
                testDegreeExt += 4
            }
            in 11..20 -> {
                testDegreeNeu += 4
            }
            in 21..30 -> {
                testDegreeAgr += 4
            }
            in 31..40 -> {
                testDegreeCon += 4
            }
            in 41..50 -> {
                testDegreeOpn += 4
            }
        }
    }

    fun getVeryAccurate() {
        if(isVeryInaccurate || isInaccurate || isNeutral || isAccurate) {
            isVeryInaccurate = false
            isInaccurate = false
            isNeutral = false
            isAccurate = false
        }
        isVeryAccurate = true

        when (questionNumber) {
            in 1..10 -> {
                testDegreeExt += 5
            }
            in 11..20 -> {
                testDegreeNeu += 5
            }
            in 21..30 -> {
                testDegreeAgr += 5
            }
            in 31..40 -> {
                testDegreeCon += 5
            }
            in 41..50 -> {
                testDegreeOpn += 5
            }
        }
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