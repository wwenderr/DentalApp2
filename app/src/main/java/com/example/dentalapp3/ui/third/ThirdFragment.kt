package com.example.dentalapp3.ui.third

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.dentalapp3.R
import com.example.dentalapp3.YourNameActivity
import kotlinx.android.synthetic.main.third_fragment.*

class ThirdFragment : Fragment(R.layout.third_fragment) {

    companion object {
        private const val KEY_SETTINGS = "mySettings"
        private const val KEY_USER_NAME = "userName"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sp = activity?.getSharedPreferences(
            KEY_SETTINGS,
            Context.MODE_PRIVATE
        )
        profile_text.text = sp?.getString(KEY_USER_NAME, "") ?: ""

        stat_button.setOnClickListener {
            val intent = Intent(activity, Statistics::class.java)
            activity?.startActivity(intent)
        }
    }

}
