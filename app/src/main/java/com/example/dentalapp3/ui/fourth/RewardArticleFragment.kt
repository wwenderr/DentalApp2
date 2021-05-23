package com.example.dentalapp3.ui.fourth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.dentalapp3.MainMenuActivity
import com.example.dentalapp3.R
import com.example.dentalapp3.ui.OnBackPressedListener
import com.example.dentalapp3.ui.second.ArticleFragment
import com.example.dentalapp3.ui.second.SecondFragment
import kotlinx.android.synthetic.main.article_fragment.*
import kotlinx.android.synthetic.main.article_fragment.title
import kotlinx.android.synthetic.main.reward_article_fragment.*

class RewardArticleFragment: Fragment(R.layout.reward_article_fragment), OnBackPressedListener {

    companion object {
        private const val POSITION = "item_position"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        var position_reward = 0
        if (bundle != null) {
            position_reward = bundle.getInt(POSITION)
        }
        val titles = resources.getStringArray(R.array.titles_reward)
        val articles = resources.getStringArray(R.array.reward_articles)
        article_image_reward.setImageResource(
            when (position_reward) {
                0 -> R.drawable.reward_brush
                1 -> R.drawable.img_teeth2
                2 -> R.drawable.img_teeth3
                3 -> R.drawable.img_teeth4
                4 -> R.drawable.img_teeth5
                5 -> R.drawable.img_teeth6
                6 -> R.drawable.img_teeth7
                7 -> R.drawable.img_teeth8
                8 -> R.drawable.img_teeth9
                9 -> R.drawable.img_teeth10
                else -> R.drawable.img_teeth17
            }
        )
        title_reward.text = titles[position_reward]
        article_reward.text = articles[position_reward]
    }

    override fun onBackPressed() {
        val fragment = FourthFragment()
        val activity = this.activity as MainMenuActivity
        activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }



}