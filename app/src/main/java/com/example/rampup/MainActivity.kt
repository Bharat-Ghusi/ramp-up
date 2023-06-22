package com.example.rampup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.rampup.activitylifecycle.ActivityLifeCycle
import com.example.rampup.databinding.ActivityMainBinding
import com.example.rampup.fragmentlifecycle.ActivityFragmentLifeCycle
import com.example.rampup.intent.ActivityIntentExample

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
            btnIntentExample.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.btnActivityLifeCycle -> redirectToActivityLifCycle()
            R.id.btnFragmentLifeCycle -> redirectToFragmentLifeCycle()
            R.id.btnIntentExample -> redirectToIntentExample()
            else -> noClickListenerAttach()
        }
    }
    /**
     * Method demonstrates Intent [explicit and Implicit]
     */
    private fun redirectToIntentExample() {
        startActivity(Intent(this,ActivityIntentExample::class.java))
    }

    /**
     * Method demonstrates Fragment life cycle
     */
    private fun redirectToFragmentLifeCycle() {
        startActivity(Intent(this,ActivityFragmentLifeCycle::class.java))
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