package com.example.rampup.activitylifecycle

import android.app.AlertDialog
import android.app.Dialog
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rampup.MainActivity
import com.example.rampup.R
import com.example.rampup.databinding.ActivityLifeCycleBinding

class ActivityLifeCycle : AppCompatActivity(),View.OnClickListener{
    companion object {
        private  val TOTAL = "total"
    }

    private  var binding: ActivityLifeCycleBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.tvAdditionStatus?.text = savedInstanceState?.getString(TOTAL) ?: "0"

        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onCreate() called."
        }

        setOnClickListener()


    }



    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onRestoreInstanceState() called."
        }
    }
    override fun onRestart() {
        super.onRestart()
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onRestart() called."
        }
    }
    override fun onStart() {
        super.onStart()
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onStart() called."
        }
    }


    override fun onResume() {
        super.onResume()
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onResume() called."
        }
    }

    override fun onPause() {
        super.onPause()
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onPause() called."
        }
    }

    override fun onStop() {
        super.onStop()
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onStop() called."
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onSaveInstanceState() called."
        }
        outState.putString(TOTAL,binding?.tvAdditionStatus?.text.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onDestroy() called."
        }
    }

    fun onWatchOverlayClick(view: View) {
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Alert").
            // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        setMessage("Are you sure want to exit").
                setPositiveButton("Yes"){
                    // When the user click yes button then app will close
                    dialog, which -> finish()
                }
        builder.setNegativeButton("No"){
            // If user click no then dialog box is canceled.
            dialog, which -> dialog.cancel()
        }
        //create dialog box and show
        builder.create().show()
    }



    private fun setOnClickListener() {
        binding?.let {
            it.btnAdd.setOnClickListener(this)
            it.tvActivityStatus.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
       when(view?.id){
           R.id.btnAdd -> updateAdditionStatus()
           R.id.tvActivityStatus -> updateActivityStatus()
       }
    }

    private fun updateAdditionStatus() {
        binding?.tvAdditionStatus?.text = (binding?.tvAdditionStatus?.text.toString().toInt() + 5).toString()
    }

    private fun updateActivityStatus() {
        binding?.let {
            it.tvActivityStatus.text = it.tvActivityStatus.text.toString() + "\n onCreate() called."
        }
    }


}