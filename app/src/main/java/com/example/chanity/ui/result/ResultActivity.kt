package com.example.chanity.ui.result

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.chanity.R
import com.example.chanity.databinding.ActivityResultBinding
import com.example.chanity.ml.Model
import com.example.chanity.ui.main.MainActivity
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

        }
    }


    private fun localModel(){


        val byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(50*4)

        val model = Model.newInstance(applicationContext)
        // Creates inputs for reference.

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 50), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

        binding.percentage1.text = outputFeature0[0].toString()
        binding.percentage2.text = outputFeature0[1].toString()
        binding.percentage3.text = outputFeature0[2].toString()
        binding.percentage4.text = outputFeature0[3].toString()
        binding.percentage5.text = outputFeature0[4].toString()

        binding.result.text = getString(R.string.result_greeting)
        binding.desc.text = getString(R.string.o_desc)
        binding.sResult.text = getString(R.string.o_strength)
        binding.wResult.text = getString(R.string.o_weakness)

        // Releases model resources if no longer used.
        model.close()
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