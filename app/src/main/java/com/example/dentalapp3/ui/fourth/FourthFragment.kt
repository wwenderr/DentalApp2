package com.example.dentalapp3.ui.fourth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dentalapp3.R
import kotlinx.android.synthetic.main.activity_rewards.*
import kotlinx.android.synthetic.main.second_fragment.*

class FourthFragment : Fragment(R.layout.activity_rewards) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val exampleListRew = generateDummyListReward(10)
        list_id1.adapter = ExampleAdapterReward(exampleListRew, context as AppCompatActivity)
        list_id1.layoutManager = LinearLayoutManager(context)
        list_id1.setHasFixedSize(true)
    }


    private fun generateDummyListReward(size: Int): List<ExampleItemReward> {
        val array = resources.getStringArray(R.array.titles_reward)
        val listReward = ArrayList<ExampleItemReward>()
        for (j in 0 until size) {
            val drawable_reward = when (j % 3) {
                0 -> R.drawable.article1
                1 -> R.drawable.article1
                else -> R.drawable.article1
            }
            val itemRew = ExampleItemReward(drawable_reward, array[j])
            listReward += itemRew
        }
        return listReward
    }
}
