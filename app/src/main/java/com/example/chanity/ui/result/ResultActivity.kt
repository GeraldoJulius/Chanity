package com.example.chanity.ui.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.chanity.R
import com.example.chanity.databinding.ActivityResultBinding
import com.example.chanity.ui.main.MainActivity
import com.example.chanity.ui.welcome.WelcomeActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                Firebase.auth.signOut()
                startActivity(Intent(this, WelcomeActivity::class.java))
                return true
            }

            R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            else -> true
        }
    }
}