package com.example.chanity.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.chanity.R

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        var ed1 : EditText = findViewById(R.id.editTextNumberDecimal)
        var ed2 : EditText = findViewById(R.id.editTextNumberDecimal2)
        var ed3 : EditText = findViewById(R.id.editTextNumberDecimal3)
        var ed4 : EditText = findViewById(R.id.editTextNumberDecimal4)
        var ed5 : EditText = findViewById(R.id.editTextNumberDecimal5)
        var ed6 : EditText = findViewById(R.id.editTextNumberDecimal6)

        var v1 : Float = ed1.text.toString().toFloat()
        var v2 : Float = ed2.text.toString().toFloat()
        var v3 : Float = ed3.text.toString().toFloat()
        var v4 : Float = ed4.text.toString().toFloat()
        var v5 : Float = ed5.text.toString().toFloat()
        var v6 : Float = ed6.text.toString().toFloat()


    }
}