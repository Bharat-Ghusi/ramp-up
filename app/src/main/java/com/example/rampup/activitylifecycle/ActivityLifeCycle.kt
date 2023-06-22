package com.example.rampup.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rampup.R

class ActivityLifeCycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }
}