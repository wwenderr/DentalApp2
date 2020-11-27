package com.example.dentalapp3

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_your_name.*
import kotlinx.android.synthetic.main.quiz_fragment.*

class QuizFragment : Fragment(R.layout.quiz_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animDrawable = quiz_fragment.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(500)
        animDrawable.start()

        var count = 0

        btnAnswer1.setOnClickListener {
            replaceQuestion(count, view)
            count++
        }

        btnAnswer2.setOnClickListener {
            replaceQuestion(count, view)
            count++
        }

        btnAnswer3.setOnClickListener {
            replaceQuestion(count, view)
            count++
        }

        btnAnswer4.setOnClickListener {
            replaceQuestion(count, view)
            count++
        }
    }

    fun replaceQuestion(count: Int, view: View) {
        view.apply {
            if(count % 2 == 0)
                view.setBackgroundResource(R.drawable.gradient_animation_quiz2)
            else
                view.setBackgroundResource(R.drawable.gradient_animation_quiz1)
            val animDrawable = quiz_fragment.background as AnimationDrawable
            animDrawable.setEnterFadeDuration(10)
            animDrawable.setExitFadeDuration(500)
            animDrawable.start()

        }
    }
}