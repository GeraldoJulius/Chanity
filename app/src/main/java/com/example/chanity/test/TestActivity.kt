package com.example.chanity.test

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.chanity.R
import com.example.chanity.databinding.ActivityTestBinding
import com.example.chanity.ml.Model
import com.example.chanity.main.MainActivity
import com.example.chanity.result.ResultActivity
import com.example.chanity.welcome.WelcomeActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var button : Button = findViewById(R.id.button4)
        button.setOnClickListener ({

            //input data
            val ed1 : EditText = findViewById(R.id.editTextNumberDecimal)
            val ed2 : EditText = findViewById(R.id.editTextNumberDecimal2)
            val ed3 : EditText = findViewById(R.id.editTextNumberDecimal3)
            val ed4 : EditText = findViewById(R.id.editTextNumberDecimal4)
            val ed5 : EditText = findViewById(R.id.editTextNumberDecimal5)
            val ed6 : EditText = findViewById(R.id.editTextNumberDecimal6)
            val ed7 : EditText = findViewById(R.id.editTextNumberDecimal7)
            val ed8 : EditText = findViewById(R.id.editTextNumberDecimal8)
            val ed9 : EditText = findViewById(R.id.editTextNumberDecimal9)
            val ed10 : EditText = findViewById(R.id.editTextNumberDecimal10)
            val ed11 : EditText = findViewById(R.id.editTextNumberDecimal11)
            val ed12 : EditText = findViewById(R.id.editTextNumberDecimal12)
            val ed13 : EditText = findViewById(R.id.editTextNumberDecimal13)
            val ed14 : EditText = findViewById(R.id.editTextNumberDecimal14)
            val ed15 : EditText = findViewById(R.id.editTextNumberDecimal15)
            val ed16 : EditText = findViewById(R.id.editTextNumberDecimal16)
            val ed17 : EditText = findViewById(R.id.editTextNumberDecimal17)
            val ed18 : EditText = findViewById(R.id.editTextNumberDecimal18)
            val ed19 : EditText = findViewById(R.id.editTextNumberDecimal19)
            val ed20 : EditText = findViewById(R.id.editTextNumberDecimal20)
            val ed21 : EditText = findViewById(R.id.editTextNumberDecimal21)
            val ed22 : EditText = findViewById(R.id.editTextNumberDecimal22)
            val ed23 : EditText = findViewById(R.id.editTextNumberDecimal23)
            val ed24 : EditText = findViewById(R.id.editTextNumberDecimal24)
            val ed25 : EditText = findViewById(R.id.editTextNumberDecimal25)
            val ed26 : EditText = findViewById(R.id.editTextNumberDecimal26)
            val ed27 : EditText = findViewById(R.id.editTextNumberDecimal27)
            val ed28 : EditText = findViewById(R.id.editTextNumberDecimal28)
            val ed29 : EditText = findViewById(R.id.editTextNumberDecimal29)
            val ed30 : EditText = findViewById(R.id.editTextNumberDecimal30)
            val ed31 : EditText = findViewById(R.id.editTextNumberDecimal31)
            val ed32 : EditText = findViewById(R.id.editTextNumberDecimal32)
            val ed33 : EditText = findViewById(R.id.editTextNumberDecimal33)
            val ed34 : EditText = findViewById(R.id.editTextNumberDecimal34)
            val ed35 : EditText = findViewById(R.id.editTextNumberDecimal35)
            val ed36 : EditText = findViewById(R.id.editTextNumberDecimal36)
            val ed37 : EditText = findViewById(R.id.editTextNumberDecimal37)
            val ed38 : EditText = findViewById(R.id.editTextNumberDecimal38)
            val ed39 : EditText = findViewById(R.id.editTextNumberDecimal39)
            val ed40 : EditText = findViewById(R.id.editTextNumberDecimal40)
            val ed41 : EditText = findViewById(R.id.editTextNumberDecimal41)
            val ed42 : EditText = findViewById(R.id.editTextNumberDecimal42)
            val ed43 : EditText = findViewById(R.id.editTextNumberDecimal43)
            val ed44 : EditText = findViewById(R.id.editTextNumberDecimal44)
            val ed45 : EditText = findViewById(R.id.editTextNumberDecimal45)
            val ed46 : EditText = findViewById(R.id.editTextNumberDecimal46)
            val ed47 : EditText = findViewById(R.id.editTextNumberDecimal47)
            val ed48 : EditText = findViewById(R.id.editTextNumberDecimal48)
            val ed49 : EditText = findViewById(R.id.editTextNumberDecimal49)
            val ed50 : EditText = findViewById(R.id.editTextNumberDecimal50)

            val v1 : Float = ed1.text.toString().toFloat()
            val v2 : Float = ed2.text.toString().toFloat()
            val v3 : Float = ed3.text.toString().toFloat()
            val v4 : Float = ed4.text.toString().toFloat()
            val v5 : Float = ed5.text.toString().toFloat()
            val v6 : Float = ed6.text.toString().toFloat()
            val v7 : Float = ed7.text.toString().toFloat()
            val v8 : Float = ed8.text.toString().toFloat()
            val v9 : Float = ed9.text.toString().toFloat()
            val v10 : Float = ed10.text.toString().toFloat()
            val v11 : Float = ed11.text.toString().toFloat()
            val v12 : Float = ed12.text.toString().toFloat()
            val v13 : Float = ed13.text.toString().toFloat()
            val v14 : Float = ed14.text.toString().toFloat()
            val v15 : Float = ed15.text.toString().toFloat()
            val v16 : Float = ed16.text.toString().toFloat()
            val v17 : Float = ed17.text.toString().toFloat()
            val v18 : Float = ed18.text.toString().toFloat()
            val v19 : Float = ed19.text.toString().toFloat()
            val v20 : Float = ed20.text.toString().toFloat()
            val v21 : Float = ed21.text.toString().toFloat()
            val v22 : Float = ed22.text.toString().toFloat()
            val v23 : Float = ed23.text.toString().toFloat()
            val v24 : Float = ed24.text.toString().toFloat()
            val v25 : Float = ed25.text.toString().toFloat()
            val v26 : Float = ed26.text.toString().toFloat()
            val v27 : Float = ed27.text.toString().toFloat()
            val v28 : Float = ed28.text.toString().toFloat()
            val v29 : Float = ed29.text.toString().toFloat()
            val v30 : Float = ed30.text.toString().toFloat()
            val v31 : Float = ed31.text.toString().toFloat()
            val v32 : Float = ed32.text.toString().toFloat()
            val v33 : Float = ed33.text.toString().toFloat()
            val v34 : Float = ed34.text.toString().toFloat()
            val v35 : Float = ed35.text.toString().toFloat()
            val v36 : Float = ed36.text.toString().toFloat()
            val v37 : Float = ed37.text.toString().toFloat()
            val v38 : Float = ed38.text.toString().toFloat()
            val v39 : Float = ed39.text.toString().toFloat()
            val v40 : Float = ed40.text.toString().toFloat()
            val v41 : Float = ed41.text.toString().toFloat()
            val v42 : Float = ed42.text.toString().toFloat()
            val v43 : Float = ed43.text.toString().toFloat()
            val v44 : Float = ed44.text.toString().toFloat()
            val v45 : Float = ed45.text.toString().toFloat()
            val v46 : Float = ed46.text.toString().toFloat()
            val v47 : Float = ed47.text.toString().toFloat()
            val v48 : Float = ed48.text.toString().toFloat()
            val v49 : Float = ed49.text.toString().toFloat()
            val v50 : Float = ed50.text.toString().toFloat()

            // masukin inputan ke model
            val byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(50*4)
            byteBuffer.putFloat(v1)
            byteBuffer.putFloat(v2)
            byteBuffer.putFloat(v3)
            byteBuffer.putFloat(v4)
            byteBuffer.putFloat(v5)
            byteBuffer.putFloat(v6)
            byteBuffer.putFloat(v7)
            byteBuffer.putFloat(v8)
            byteBuffer.putFloat(v9)
            byteBuffer.putFloat(v10)
            byteBuffer.putFloat(v11)
            byteBuffer.putFloat(v12)
            byteBuffer.putFloat(v13)
            byteBuffer.putFloat(v14)
            byteBuffer.putFloat(v15)
            byteBuffer.putFloat(v16)
            byteBuffer.putFloat(v17)
            byteBuffer.putFloat(v18)
            byteBuffer.putFloat(v19)
            byteBuffer.putFloat(v20)
            byteBuffer.putFloat(v21)
            byteBuffer.putFloat(v22)
            byteBuffer.putFloat(v23)
            byteBuffer.putFloat(v24)
            byteBuffer.putFloat(v25)
            byteBuffer.putFloat(v26)
            byteBuffer.putFloat(v27)
            byteBuffer.putFloat(v28)
            byteBuffer.putFloat(v29)
            byteBuffer.putFloat(v30)
            byteBuffer.putFloat(v31)
            byteBuffer.putFloat(v32)
            byteBuffer.putFloat(v33)
            byteBuffer.putFloat(v34)
            byteBuffer.putFloat(v35)
            byteBuffer.putFloat(v36)
            byteBuffer.putFloat(v37)
            byteBuffer.putFloat(v38)
            byteBuffer.putFloat(v39)
            byteBuffer.putFloat(v40)
            byteBuffer.putFloat(v41)
            byteBuffer.putFloat(v42)
            byteBuffer.putFloat(v43)
            byteBuffer.putFloat(v44)
            byteBuffer.putFloat(v45)
            byteBuffer.putFloat(v46)
            byteBuffer.putFloat(v47)
            byteBuffer.putFloat(v48)
            byteBuffer.putFloat(v49)
            byteBuffer.putFloat(v50)

            val model = Model.newInstance(applicationContext)
            // Creates inputs for reference.

            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 50), DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)

            // Runs model inference and gets result.
            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

            //test nampilin hasil index
            val traits = outputFeature0

            val intentResult = Intent(this@TestActivity,ResultActivity::class.java)
            val bundle = Bundle()

            bundle.putFloat("traits",traits[0])
            bundle.putFloat("traits1",traits[1])
            bundle.putFloat("traits2",traits[2])
            bundle.putFloat("traits3",traits[3])
            bundle.putFloat("traits4",traits[4])

            intentResult.putExtras(bundle)

            startActivity(intentResult)
        })
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

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.warning))
            setMessage(getString(R.string.quit_test))
            setPositiveButton(getString(R.string.yesbutton)) { _, _ ->
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
            setNegativeButton(getString(R.string.nobutton)) { _, _ ->
                Toast.makeText(context, getString(R.string.okay), Toast.LENGTH_SHORT).show()
            }
            create()
            show()
        }
    }
}

