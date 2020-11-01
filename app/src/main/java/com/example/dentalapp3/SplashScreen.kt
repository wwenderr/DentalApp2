 package com.example.dentalapp3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_splash_screen.*

 lateinit var handler: Handler


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        setContentView(R.layout.activity_splash_screen)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.tooth}")
        videoView2.setVideoPath(uri.toString())
        videoView2.setOnCompletionListener{
            val r = object:Runnable{
                override fun run() {
                    startActivity(Intent(this@SplashScreen,Greetings::class.java))
                    finish()
                }


            }
            Handler().postDelayed(r, 500)
        }

        videoView2.start()



        /*videoView2.setOnCompletionListener {

        }
        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 1000)*/
    }
}