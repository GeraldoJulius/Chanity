package com.example.chanity.ui.signin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.example.chanity.R
import com.example.chanity.databinding.ActivitySigninBinding
import com.example.chanity.ui.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

        auth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, getString(R.string.emptyEmail), Toast.LENGTH_SHORT).show()
            }
            else if (password.isEmpty()) {
                Toast.makeText(this, getString(R.string.emptyPassword), Toast.LENGTH_SHORT).show()
            }
            else {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun setupView() {
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
}