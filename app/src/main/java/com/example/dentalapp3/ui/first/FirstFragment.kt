package com.example.dentalapp3.ui.first

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.dentalapp3.R
import com.example.dentalapp3.YourNameActivity
import com.example.dentalapp3.ui.third.NotificationSettings
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.first_task.*

class FirstFragment: Fragment(R.layout.first_fragment) {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

 }
