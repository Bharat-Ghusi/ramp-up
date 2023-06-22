package com.example.rampup.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rampup.R
import com.example.rampup.databinding.ActivityIntentExampleBinding
import com.example.rampup.destination.ActivityDestination

class ActivityIntentExample : AppCompatActivity(), View.OnClickListener{
    companion object{
        private const val INFO = "info"
    }
    private var binding:ActivityIntentExampleBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentExampleBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding?.let {
            it.btnExplicit.setOnClickListener(this)
            it.btnImplicit.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnImplicit -> redirectToGoogle()
            R.id.btnExplicit -> redirectToActivityDestination()
        }
    }

    private fun redirectToGoogle() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")))
    }

    private fun redirectToActivityDestination() {
        val intent = Intent(this,ActivityDestination::class.java)
        intent.putExtra(INFO,"Passed info.")
        startActivity(intent)
    }
}