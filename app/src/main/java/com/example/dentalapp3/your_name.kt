package com.example.dentalapp3

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.dentalapp3.dataBase.DatabaseHandler
import com.example.dentalapp3.dataBase.User
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_your_name.*
import kotlinx.android.synthetic.main.notification_task.view.*

class your_name : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()


        setContentView(R.layout.activity_your_name)

        val context = this


         continue_button.setOnClickListener {
            if(personName.text.toString().isNotEmpty()){
                val user =
                    User(personName.text.toString())
                    DatabaseHandler(context)
                    .also {
                    it.insertData(user)

                    val dialog = BottomSheetDialog(this)
                    val view = layoutInflater.inflate(R.layout.notification_task,null)
                    dialog.setContentView(view)
                    dialog.show()

                    view.ready_button.setOnClickListener{
                        this.intent = Intent(this, first_task::class.java)
                        startActivity(this.intent) 
                    }
                }
            }else{
                Toast.makeText(context,"Please, fill a gap",Toast.LENGTH_SHORT).show()
            }
        }

        val animDrawable = back_name.foreground as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(500)
        animDrawable.start()
    }
}