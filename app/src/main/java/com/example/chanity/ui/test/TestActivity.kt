package com.example.chanity.ui.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.chanity.R
import com.example.chanity.databinding.ActivityTestBinding
import com.example.chanity.ui.result.ResultActivity
import com.example.chanity.ui.test.fragment.TestFragment1

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setupAction()

        val mFragmentManager = supportFragmentManager
        val mTestFragment = TestFragment1()
        val fragment = mFragmentManager.findFragmentByTag(TestFragment1::class.java.simpleName)

        if (fragment !is TestFragment1) {
            Log.d("TestFragment", "Fragment Name :" + TestFragment1::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mTestFragment, TestFragment1::class.java.simpleName)
                .commit()
        }

    }

    /*private fun setupAction() {
        binding.button2.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }*/

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
                /*MainViewModel.logout()*/
                return true
            }
            else -> true
        }
    }
}