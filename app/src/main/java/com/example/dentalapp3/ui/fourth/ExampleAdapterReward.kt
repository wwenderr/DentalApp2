package com.example.dentalapp3.ui.fourth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dentalapp3.R
import com.example.dentalapp3.ui.second.ArticleFragment
import kotlinx.android.synthetic.main.example_item.view.*
import kotlinx.android.synthetic.main.reward_example_item.view.*

class ExampleAdapterReward(private val exampleList: List<ExampleItemReward>, private val activity: AppCompatActivity):
    RecyclerView.Adapter<ExampleAdapterReward.ExampleViewHolderReward>() {

    companion object{
        private const val POSITION = "item_position"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleAdapterReward.ExampleViewHolderReward =
        ExampleViewHolderReward(
            LayoutInflater.from(parent.context).inflate(R.layout.reward_example_item, parent, false)
        )

    override fun getItemCount(): Int = exampleList.size


    override fun onBindViewHolder(holder: ExampleAdapterReward.ExampleViewHolderReward, position: Int) {
        val currentItemReward = exampleList[position]
        holder.onBind(currentItemReward)
        holder.view.setOnClickListener {
            val fragment_reward = RewardArticleFragment()
            val bundle = Bundle()
            bundle.putInt(POSITION, position)
            fragment_reward.arguments = bundle
            activity.supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragment_reward)
                commit()
            }
        }
    }


    inner class ExampleViewHolderReward(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(currentItem: ExampleItemReward) {
            view.apply {
                article_image_reward.setImageResource(currentItem.imageResource)
                main_text_reward.text = currentItem.text1
//                sub_text.text = currentItem.text2
            }
        }
    }
}