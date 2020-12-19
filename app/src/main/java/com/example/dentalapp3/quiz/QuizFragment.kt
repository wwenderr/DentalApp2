package com.example.dentalapp3.quiz

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import com.example.dentalapp3.MainMenuActivity
import com.example.dentalapp3.R
import kotlinx.android.synthetic.main.quiz_fragment.*

class QuizFragment : Fragment(R.layout.quiz_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animDrawable = quiz_fragment.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(500)
        animDrawable.start()

        var count = 0
        val ans = ArrayList<Int>()
        replaceQuestion(count, view)
        count++

        btnAnswer1.setOnClickListener {
            replaceQuestion(count, view)
            ans.add(1)
            count++
        }

        btnAnswer2.setOnClickListener {
            replaceQuestion(count, view)
            ans.add(2)
            count++
        }

        btnAnswer3.setOnClickListener {
            replaceQuestion(count, view)
            ans.add(3)
            count++
        }

        btnAnswer4.setOnClickListener {
            replaceQuestion(count, view)
            ans.add(4)
            count++
        }

        btnAnswer5.setOnClickListener {
            if(btnAnswer5.visibility == Group.VISIBLE) {
                replaceQuestion(count, view)
                ans.add(5)
                count++
            }
        }

    }

    private fun replaceQuestion(count: Int, view: View) {
        if (count >= 7) startNewActivity()
        else {
            val questions = resources.getStringArray(R.array.questions_for_quiz)
            val strings = resources.getStringArray(
                when (count) {
                    0 -> R.array.answers_for_first_question
                    1 -> R.array.answers_for_second_question
                    2 -> R.array.answers_for_third_question
                    3 -> R.array.answers_for_fourth_question
                    4 -> R.array.answers_for_fifth_question
                    5 -> R.array.answers_for_sixth_question
                    else -> R.array.answers_for_seventh_question
                }
            )
            view.apply {
                if (count % 2 == 0)
                    view.setBackgroundResource(R.drawable.gradient_animation_quiz1)
                else
                    view.setBackgroundResource(R.drawable.gradient_animation_quiz2)
                val animDrawable = quiz_fragment.background as AnimationDrawable
                animDrawable.setEnterFadeDuration(10)
                animDrawable.setExitFadeDuration(500)
                animDrawable.start()

                txtQuestion.text = questions[count]
                btnAnswer1.text = strings[0]
                btnAnswer2.text = strings[1]
                btnAnswer3.text = strings[2]
                btnAnswer4.text = strings[3]
                if (count == 5) {
                    btnAnswer5.visibility = Group.VISIBLE
                    btnAnswer5.text = strings[4]
                } else if (count == 6) {
                    btnAnswer5.visibility = Group.INVISIBLE
                }
            }
        }
    }

    private fun startNewActivity() {
        val mainMenuActivity = MainMenuActivity()
        val intent = Intent(context, mainMenuActivity::class.java)
        startActivity(intent)
    }
}