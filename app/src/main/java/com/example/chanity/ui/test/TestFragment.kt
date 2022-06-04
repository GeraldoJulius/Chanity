package com.example.chanity.ui.test

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chanity.R
import com.example.chanity.databinding.FragmentTestBinding
import com.example.chanity.ui.result.ResultActivity

class TestFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding
    private lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)
        binding.testViewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.navigateToResult.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {

                activity?.let {
                    val intent = Intent(it, ResultActivity::class.java)
                    it.startActivity(intent)
                }
            }
        })
        return binding.root
    }
}





