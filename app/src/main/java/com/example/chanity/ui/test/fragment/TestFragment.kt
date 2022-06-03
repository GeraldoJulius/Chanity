package com.example.chanity.ui.test.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.chanity.R
import com.example.chanity.databinding.FragmentTestBinding
import com.example.chanity.ui.test.TestViewModel

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

                val testDegree = viewModel.testDegree

                /*val action =
                    TestFragmentDirections.actionTestFragmentToTestResultsFragment(
                        testDegree
                    )
                findNavController().navigate(action)*/
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref?.edit()) {
                    this?.putInt("testDegree", testDegree)
                        ?.commit()
                }
            }
        })
        return binding.root
    }
}





