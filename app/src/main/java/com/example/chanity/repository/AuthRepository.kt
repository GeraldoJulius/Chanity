package com.example.chanity.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository {
    private lateinit var application: Application
    private lateinit var firebaseUserMutableLiveData: MutableLiveData<FirebaseUser>
    private lateinit var auth: FirebaseAuth
    private lateinit var messageLiveData: MutableLiveData<String>

    fun register(email: String, password: String) {
        auth = FirebaseAuth.getInstance()
        application = Application()
        firebaseUserMutableLiveData = MutableLiveData()
        messageLiveData = MutableLiveData<String>()

        if (email == "" || password == "") {
            messageLiveData.postValue("Email and password can't be empty")
        }
        else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    firebaseUserMutableLiveData.postValue(auth.currentUser)
            }
                else {
                    messageLiveData.postValue("Register Failed")
                }
            }
        }
    }

    /*fun authRepository(application: Application) {
        this.application = application
        auth = FirebaseAuth.getInstance()
        firebaseUserMutableLiveData = MutableLiveData()

        if (auth.currentUser != null) {
            firebaseUserMutableLiveData.postValue(auth.currentUser)
        }
    }*/
}