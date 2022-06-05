package com.example.chanity.ui.test.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.chanity.R

class TestFragment8 : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test8, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNext: Button = view.findViewById(R.id.button2)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button2) {
            val mTestFragment9 = TestFragment9()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, mTestFragment9, TestFragment9::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}
