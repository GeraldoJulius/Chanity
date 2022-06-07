/*
package com.example.chanity.ui.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chanity.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var appRepository: AuthRepository
    private lateinit var userMutableLiveData: MutableLiveData<FirebaseUser>

    fun register(email: String, password: String) {
        appRepository = AuthRepository()
        appRepository.register(email = email, password = password)
    }
}*/
