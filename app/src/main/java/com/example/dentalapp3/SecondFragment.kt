package com.example.dentalapp3

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment: Fragment(R.layout.second_fragment) {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exampleList = generateDummyList(12)
        list_id.adapter = ExampleAdapter(exampleList)
        /*list_id.layoutManager = LinearLayoutManager(this)*/

        list_id.setHasFixedSize(true)
    }


    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.article1
                1 -> R.drawable.article2
                else -> R.drawable.article
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}