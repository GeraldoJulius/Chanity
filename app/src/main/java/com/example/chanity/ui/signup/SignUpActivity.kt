package com.example.chanity.ui.signup

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.chanity.R
import com.example.chanity.databinding.ActivitySignupBinding
import com.example.chanity.model.User
import com.example.chanity.ui.signin.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database.getReference("Chanity").child("User")

        binding.signupButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val id = databaseReference.push().key
            val user = User(email, password, id!!)

                if (email.isEmpty()) {
                    Toast.makeText(this, getString(R.string.emptyEmail), Toast.LENGTH_SHORT).show()
                } else if (password.isEmpty()) {
                    Toast.makeText(this, getString(R.string.emptyPassword), Toast.LENGTH_SHORT)
                        .show()
                } else {
                    databaseReference.child(id).setValue(user)
                    Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show()

                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            AlertDialog.Builder(this).apply {
                                setTitle(getString(R.string.message_title))
                                setMessage(getString(R.string.message_body))
                                setPositiveButton(getString(R.string.posbutton)) { _, _ ->
                                    val intent = Intent(context, SignInActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                                create()
                                show()
                            }
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