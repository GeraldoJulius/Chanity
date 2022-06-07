package com.example.chanity.ui.test.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.chanity.R
import com.example.chanity.databinding.FragmentTest1Binding
import com.example.chanity.ui.test.TestViewModel

class TestFragment1 : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentTest1Binding
    private lateinit var testViewModel: TestViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        testViewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNext: Button = view.findViewById(R.id.button2)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (v.id == R.id.button2) {
            val mTestFragment2 = TestFragment2()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, mTestFragment2, TestFragment2::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

}