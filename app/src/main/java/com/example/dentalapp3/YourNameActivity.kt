package com.example.dentalapp3

import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.dentalapp3.quiz.QuizActivity
import kotlinx.android.synthetic.main.activity_your_name.*

class YourNameActivity : AppCompatActivity() {

    companion object {
        private const val KEY_SETTINGS = "mySettings"
        private const val KEY_USER_NAME = "userName"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()
        setContentView(R.layout.activity_your_name)

        val context = this

        continue_button.setOnClickListener {
            if (personName.text.toString().isNotEmpty()) {
                val sp = getSharedPreferences(
                    KEY_SETTINGS,
                    Context.MODE_PRIVATE
                )
                val e = sp.edit()
                e.putString(KEY_USER_NAME, personName.text.toString())
                e.apply()
                val quizActivity = QuizActivity()
                val intent = Intent(this, quizActivity::class.java)
                startActivity(intent)
//                val user =
//                    User(personName.text.toString())
//                DatabaseHandler(context)
//                    .also {
//                        it.insertData(user)
//
//                        val dialog = BottomSheetDialog(this)
//                        val view = layoutInflater.inflate(R.layout.notification_task, null)
//                        dialog.setContentView(view)
//                        dialog.show()
//
//                        view.ready_button.setOnClickListener {
////                            this.intent = Intent(this, FirstTask::class.java)
////                            startActivity(this.intent)
//
//                        }
//                    }
            } else {
                Toast.makeText(context, "Please, fill a gap", Toast.LENGTH_SHORT).show()
            }
        }

        val animDrawable = back_name.foreground as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(500)
        animDrawable.start()
    }
}