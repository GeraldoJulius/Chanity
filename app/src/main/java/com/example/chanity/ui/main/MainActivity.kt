package com.example.chanity.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import com.example.chanity.R
import com.example.chanity.databinding.ActivityMainBinding
import com.example.chanity.ui.test.TestActivity
import com.example.chanity.ui.welcome.WelcomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
        userSession()
    }

    private fun setupAction() {
        binding.button.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }
    }
    private fun userSession(){
        val auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if (currentuser == null) {
            startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
            finish()
        }
    }
        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.option_menu, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.language -> {
                    startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
                    return true
                }
                R.id.logout -> {
                    Firebase.auth.signOut()
                    startActivity(Intent(this, WelcomeActivity::class.java))
                    return true
                }
                else -> true
            }
        }
}