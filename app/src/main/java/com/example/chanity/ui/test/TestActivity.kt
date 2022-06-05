package com.example.chanity.ui.test

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.chanity.R
import com.example.chanity.databinding.ActivityTestBinding
import com.example.chanity.ui.main.MainActivity
import com.example.chanity.ui.welcome.WelcomeActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val mTestFragment = TestFragment()
        val fragment = mFragmentManager.findFragmentByTag(TestFragment::class.java.simpleName)

        if (fragment !is TestFragment) {
            Log.d("TestFragment", "Fragment Name :" + TestFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mTestFragment, TestFragment::class.java.simpleName)
                .commit()
        }
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