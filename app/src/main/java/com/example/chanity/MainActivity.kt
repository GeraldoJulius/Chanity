package com.example.chanity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.chanity.databinding.ActivityMainBinding
import com.example.chanity.databinding.ActivitySigninBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.button.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
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
                    /*MainViewModel.logout()*/
                    return true
                }
                else -> true
            }
        }
}