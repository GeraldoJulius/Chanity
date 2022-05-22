package com.example.chanity.helper

import android.view.View

val EMAIL_REGEX by lazy { "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})" }
fun emailValid(email: String): Boolean {
    return EMAIL_REGEX.toRegex().matches(email)
}

fun showLoading(isLoading: Boolean, view: View) {
    if (isLoading) {
        view.visibility = View.VISIBLE
    }
    else {
        view.visibility = View.INVISIBLE
    }
}