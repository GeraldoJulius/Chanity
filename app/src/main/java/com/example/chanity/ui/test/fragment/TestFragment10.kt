package com.example.chanity.ui.test.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.chanity.R
import com.example.chanity.ui.result.ResultActivity
class TestFragment10 : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test10, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNext: Button = view.findViewById(R.id.button3)
        btnNext.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button3) {
            val intent = Intent(activity, ResultActivity::class.java)
            startActivity(intent)
        }
    }
}
