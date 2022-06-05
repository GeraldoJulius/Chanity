package com.example.chanity.ui.result

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.chanity.R
import com.example.chanity.databinding.ActivityResultBinding
import com.example.chanity.ui.main.MainActivity
import com.example.chanity.ui.welcome.WelcomeActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var resultViewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultViewModel = ViewModelProvider(this).get(ResultViewModel::class.java)

        setupViewModel()
    }

    @SuppressLint("StringFormatInvalid")
    private fun setupViewModel() {
        resultViewModel.postQuiz()

        resultViewModel.quizResponse.observe(this) {

            binding.result.text = getString(R.string.result_greeting)

            binding.percentage1.text = getString(R.string.o_percentage, it.openness.toString())
            binding.percentage2.text = getString(R.string.c_percentage, it.conscientiousness.toString())
            binding.percentage3.text = getString(R.string.e_percentage, it.extraversion.toString())
            binding.percentage4.text = getString(R.string.a_percentage, it.agreeableness.toString())
            binding.percentage5.text = getString(R.string.n_percentage, it.neuroticism.toString())

            binding.desc.text = getString(R.string.o_desc)
            binding.sResult.text = getString(R.string.o_strength)
            binding.wResult.text = getString(R.string.o_weakness)
        }
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
            R.id.language -> {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
                return true
            }
            R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            else -> true
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}