package com.example.dentalapp3.articles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.dentalapp3.R
import kotlinx.android.synthetic.main.article_fragment.*

class ArticleFragment : Fragment(R.layout.article_fragment) {

    companion object {
        private const val POSITION = "item_position"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        var position = 0
        if (bundle != null) {
            position = bundle.getInt(POSITION)
        }
        val titles = resources.getStringArray(R.array.titles)
        val articles = resources.getStringArray(R.array.articles)
        article_img.setImageResource(
            when (position) {
                0 -> R.drawable.img_teeth1
                1 -> R.drawable.img_teeth2
                2 -> R.drawable.img_teeth3
                3 -> R.drawable.img_teeth4
                4 -> R.drawable.img_teeth5
                5 -> R.drawable.img_teeth6
                else -> R.drawable.img_teeth7
            }
        )
        title.text = titles[position]
        article.text = articles[position]
    }
}