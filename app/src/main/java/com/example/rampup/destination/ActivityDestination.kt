package com.example.rampup.destination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.rampup.R
import com.example.rampup.databinding.ActivityDestinationBinding

class ActivityDestination : AppCompatActivity() {
    companion object{
        private const val INFO = "info"
    }
    private var binding:ActivityDestinationBinding ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.textDestination?.text = intent.getStringExtra(INFO)?.toString()
    }
}