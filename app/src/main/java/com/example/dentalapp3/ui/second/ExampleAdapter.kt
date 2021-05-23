package com.example.dentalapp3.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dentalapp3.R
import com.example.dentalapp3.ui.fourth.RewardArticleFragment
import kotlinx.android.synthetic.main.example_item.view.*

class  ExampleAdapter(private val exampleList: List<ExampleItem>, private val activity: AppCompatActivity) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    companion object{
        private const val POSITION = "item_position"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder =
        ExampleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        )

    override fun getItemCount(): Int = exampleList.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.onBind(currentItem)
        holder.view.setOnClickListener {
            val fragment = RewardArticleFragment()
            val bundle = Bundle()
            bundle.putInt(POSITION, position)
            fragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragment)
                commit()
            }
        }
    }

    inner class ExampleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(currentItem: ExampleItem) {
            view.apply {
                article_image.setImageResource(currentItem.imageResource)
                main_text.text = currentItem.text1
//                sub_text.text = currentItem.text2
            }
        }
    }
}