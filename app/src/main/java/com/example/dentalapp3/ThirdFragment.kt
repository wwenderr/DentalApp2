package com.example.dentalapp3

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.notification_settings.*
import kotlinx.android.synthetic.main.third_fragment.*

class ThirdFragment: Fragment(R.layout.third_fragment) {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        stat_button.setOnClickListener{
            val intent = Intent (activity, Statistics::class.java)
            activity?.startActivity(intent)
        }




    }


}
