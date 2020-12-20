package com.example.dentalapp3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {

    companion object {
        private const val KEY_SETTINGS = "mySettings"
        private const val KEY_USER_NAME = "userName"
        private const val KEY_HAS_VISITED = "hasVisited"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        setContentView(R.layout.activity_splash_screen)

        val sp = getSharedPreferences(
            KEY_SETTINGS,
            Context.MODE_PRIVATE
        )
        val hasVisited = sp.getBoolean(KEY_HAS_VISITED, false)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.tooth}")
        videoView2.setVideoPath(uri.toString())
        videoView2.setOnCompletionListener {
            val r = Runnable {
                if (!hasVisited || sp.getString(KEY_USER_NAME, "").isNullOrEmpty()) {
                    val e = sp.edit()
                    e.putBoolean(KEY_HAS_VISITED, true)
                    e.apply()
                    startActivity(Intent(this, Greetings::class.java))
                } else
                    startActivity(Intent(this, MainMenuActivity::class.java))
                finish()
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

