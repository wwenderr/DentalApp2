package com.example.dentalapp3

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_task.*
import kotlinx.android.synthetic.main.notification_settings.*

class notification_settings: AppCompatActivity() {

    var isCheckedDone = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()


        setContentView(R.layout.notification_settings)

       /* lottie_check_box.setOnClickListener{
            if(isCheckedDone){
                lottie_check_box.speed = -1f
                lottie_check_box.playAnimation()
                isCheckedDone = false
            }else{
                lottie_check_box.speed = 1f
                lottie_check_box.playAnimation()
                isCheckedDone = true
            }
        }*/


        ready_notific_button.setOnClickListener {

            val am_7 = am_checkBox.isChecked
            val am_8 = am_checkBox2.isChecked

            this.intent = Intent(this, MainMenuActivity::class.java)
            startActivity(this.intent)

        }


        val animDrawable = imageView3.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(500)
        animDrawable.start()

    }
}