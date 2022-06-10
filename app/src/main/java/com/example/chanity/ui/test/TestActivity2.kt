package com.example.chanity.ui.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.chanity.R
import com.example.chanity.databinding.ActivityResultBinding
import com.example.chanity.databinding.ActivityTest2Binding
import com.example.chanity.ml.Model
import com.example.chanity.ui.result.ResultActivity
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class TestActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityTest2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)


        var button : Button = findViewById(R.id.button4)
        button.setOnClickListener(View.OnClickListener {


            //input data
            val ed1 : EditText = findViewById(R.id.editTextNumberDecimal)
            val ed2 : EditText = findViewById(R.id.editTextNumberDecimal2)
            val ed3 : EditText = findViewById(R.id.editTextNumberDecimal3)
            val ed4 : EditText = findViewById(R.id.editTextNumberDecimal4)
            val ed5 : EditText = findViewById(R.id.editTextNumberDecimal5)
            val ed6 : EditText = findViewById(R.id.editTextNumberDecimal6)

            val v1 : Float = ed1.text.toString().toFloat()
            val v2 : Float = ed2.text.toString().toFloat()
            val v3 : Float = ed3.text.toString().toFloat()
            val v4 : Float = ed4.text.toString().toFloat()
            val v5 : Float = ed5.text.toString().toFloat()
            val v6 : Float = ed6.text.toString().toFloat()



            // masukin inputan ke model
            val byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(50*4)
            byteBuffer.putFloat(v1)
            byteBuffer.putFloat(v2)
            byteBuffer.putFloat(v3)
            byteBuffer.putFloat(v4)
            byteBuffer.putFloat(v5)
            byteBuffer.putFloat(v6)

            val model = Model.newInstance(applicationContext)
            // Creates inputs for reference.

            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 50), DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)

            // Runs model inference and gets result.
            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray


            //test nampilin hasil index
            val traits= outputFeature0






            val intentResult = Intent(this@TestActivity2,ResultActivity::class.java)
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

}

