package com.example.dentalapp3.ui.first

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.dentalapp3.R

class FirstFragment: Fragment(R.layout.first_fragment) {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*progressBar_task.max = 1000
        val currentProgress = 600

        ObjectAnimator.ofInt(progressBar_task, "progress", currentProgress)
            .setDuration(2000)
            .start()*/

    }

}