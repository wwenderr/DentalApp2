package com.example.dentalapp3

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.dentalapp3.ui.third.NotificationSettings
import kotlinx.android.synthetic.main.first_task.*

class FirstTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()


        setContentView(R.layout.first_task)


        accept_button.setOnClickListener {
            this.intent = Intent(this, NotificationSettings::class.java)
            startActivity(this.intent)
        }

        val animDrawable = imageView2.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(500)
        animDrawable.start()
    }
}