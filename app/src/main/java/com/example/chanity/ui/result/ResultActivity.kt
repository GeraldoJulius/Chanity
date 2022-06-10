package com.example.chanity.ui.result

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.chanity.R
import com.example.chanity.databinding.ActivityResultBinding
import com.example.chanity.ml.Model
import com.example.chanity.ui.main.MainActivity
import com.example.chanity.ui.test.TestActivity2
import com.example.chanity.ui.welcome.WelcomeActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.net.URLClassLoader.newInstance
import java.nio.ByteBuffer

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var resultViewModel: ResultViewModel
    private lateinit var resultModel : TestActivity2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultViewModel = ViewModelProvider(this).get(ResultViewModel::class.java)


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
    }
    else if(maxIdx == 1){
        binding.percentage1.text = getString(R.string.index1O)
        binding.percentage2.text = getString(R.string.index1C)
        binding.percentage3.text = getString(R.string.index1E)
        binding.percentage4.text = getString(R.string.index1A)
        binding.percentage5.text = getString(R.string.index1N)
    }
    else if(maxIdx == 2){
        binding.percentage1.text = getString(R.string.index2O)
        binding.percentage2.text = getString(R.string.index2C)
        binding.percentage3.text = getString(R.string.index2E)
        binding.percentage4.text = getString(R.string.index2A)
        binding.percentage5.text = getString(R.string.index2N)
    }
    else if(maxIdx == 3){
        binding.percentage1.text = getString(R.string.index3O)
        binding.percentage2.text = getString(R.string.index3C)
        binding.percentage3.text = getString(R.string.index3E)
        binding.percentage4.text = getString(R.string.index3A)
        binding.percentage5.text = getString(R.string.index3N)
    }

    else{
        binding.percentage1.text = getString(R.string.index4O)
        binding.percentage2.text = getString(R.string.index4C)
        binding.percentage3.text = getString(R.string.index4E)
        binding.percentage4.text = getString(R.string.index4A)
        binding.percentage5.text = getString(R.string.index4N)
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
    companion object{
        const val EXTRA_FLOAT = "traits"
    }
}