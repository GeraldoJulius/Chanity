package com.example.chanity.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import com.example.chanity.R
import com.example.chanity.databinding.ActivityResultBinding
import com.example.chanity.main.MainActivity
import com.example.chanity.test.TestActivity
import com.example.chanity.welcome.WelcomeActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getResult()
    }

private fun getResult(){
    val bundle = intent.extras

    val traits1 = bundle?.getFloat("traits")
    val traits2 = bundle?.getFloat("traits1")
    val traits3 = bundle?.getFloat("traits2")
    val traits4 = bundle?.getFloat("traits3")
    val traits5 = bundle?.getFloat("traits4")

    val traits = listOf(traits1,traits2,traits3,traits4,traits5)

    val maxIdx = traits.indices.maxByOrNull { traits[it]!! }

    if (maxIdx == 0 ){
        binding.percentage1.text = getString(R.string.index0O)
        binding.percentage2.text = getString(R.string.index0C)
        binding.percentage3.text = getString(R.string.index0E)
        binding.percentage4.text = getString(R.string.index0A)
        binding.percentage5.text = getString(R.string.index0N)
        binding.result.text = getString(R.string.o_result_greeting)
        binding.desc.text = getString(R.string.o_desc)
        binding.sResult.text = getString(R.string.o_strength)
        binding.wResult.text = getString(R.string.o_weakness)
    }
    else if(maxIdx == 1){
        binding.percentage1.text = getString(R.string.index1O)
        binding.percentage2.text = getString(R.string.index1C)
        binding.percentage3.text = getString(R.string.index1E)
        binding.percentage4.text = getString(R.string.index1A)
        binding.percentage5.text = getString(R.string.index1N)
        binding.result.text = getString(R.string.n_result_greeting)
        binding.desc.text = getString(R.string.n_desc)
        binding.sResult.text = getString(R.string.n_strength)
        binding.wResult.text = getString(R.string.n_weakness)
    }
    else if(maxIdx == 2){
        binding.percentage1.text = getString(R.string.index2O)
        binding.percentage2.text = getString(R.string.index2C)
        binding.percentage3.text = getString(R.string.index2E)
        binding.percentage4.text = getString(R.string.index2A)
        binding.percentage5.text = getString(R.string.index2N)
        binding.result.text = getString(R.string.o_result_greeting)
        binding.desc.text = getString(R.string.o_desc)
        binding.sResult.text = getString(R.string.o_strength)
        binding.wResult.text = getString(R.string.o_weakness)
    }
    else if(maxIdx == 3){
        binding.percentage1.text = getString(R.string.index3O)
        binding.percentage2.text = getString(R.string.index3C)
        binding.percentage3.text = getString(R.string.index3E)
        binding.percentage4.text = getString(R.string.index3A)
        binding.percentage5.text = getString(R.string.index3N)
        binding.result.text = getString(R.string.a_result_greeting)
        binding.desc.text = getString(R.string.a_desc)
        binding.sResult.text = getString(R.string.a_strength)
        binding.wResult.text = getString(R.string.a_weakness)
    }

    else{
        binding.percentage1.text = getString(R.string.index4O)
        binding.percentage2.text = getString(R.string.index4C)
        binding.percentage3.text = getString(R.string.index4E)
        binding.percentage4.text = getString(R.string.index4A)
        binding.percentage5.text = getString(R.string.index4N)
        binding.result.text = getString(R.string.a_result_greeting)
        binding.desc.text = getString(R.string.a_desc)
        binding.sResult.text = getString(R.string.a_strength)
        binding.wResult.text = getString(R.string.a_weakness)
    }
}

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
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
            else -> true
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object{
        const val EXTRA_FLOAT = "traits"
    }
}