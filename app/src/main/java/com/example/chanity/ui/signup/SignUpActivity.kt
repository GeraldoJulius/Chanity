package com.example.chanity.ui.signup

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.chanity.R
import com.example.chanity.databinding.ActivitySignupBinding
import com.example.chanity.ui.welcome.WelcomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding
    /*private lateinit var signUpViewModel: SignUpViewModel*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, WelcomeActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else {
                Toast.makeText(this, "Fields are not allowed to be empty", Toast.LENGTH_SHORT).show()
            }


        /*setupView()
        setupViewModel()
        setupAction()*/
    }
}

    /*private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupViewModel() {
        signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
    }

    private fun setupAction() {
        binding.signupButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            signUpViewModel.register(email, password)

            when {
                email.isEmpty() -> {
                    binding.emailEditTextLayout.error = getString(R.string.emptyEmail)
                }
                password.isEmpty() -> {
                    binding.passwordEditTextLayout.error = getString(R.string.emptyPassword)
                }
                else -> {
                    AlertDialog.Builder(this).apply {
                        setTitle(getString(R.string.message_title))
                        setMessage(getString(R.string.message_body))
                        setPositiveButton(getString(R.string.posbutton)) { _, _ ->
                            startActivity(Intent(context, WelcomeActivity::class.java))
                            finish()
                        }
                        create()
                        show()
                    }
                }
            }
        }
    }*/
}