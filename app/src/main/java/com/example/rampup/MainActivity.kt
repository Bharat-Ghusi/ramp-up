package com.example.rampup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.rampup.activitylifecycle.ActivityLifeCycle
import com.example.rampup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private  val TAG = MainActivity::class.java.simpleName
    }
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setClickListener()
    }

    /**
     * Your comments
     */
    private fun setClickListener() {
        binding?.apply {
            btnActivityLifeCycle.setOnClickListener(this@MainActivity)
            btnFragmentLifeCycle.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.btnActivityLifeCycle -> redirectToActivityLifCycle()
            else -> noClickListenerAttach()
        }
    }

    /**
     * Your comments
     */
    private fun redirectToActivityLifCycle() {
        startActivity(Intent(this, ActivityLifeCycle::class.java))
    }

    /**
     * Your comments
     */
    private fun noClickListenerAttach() {
        runOnUiThread {
            Toast.makeText(this, "No click listener attached", Toast.LENGTH_SHORT).show()
        }
    }
}