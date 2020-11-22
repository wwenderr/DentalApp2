package com.example.dentalapp3.articles

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dentalapp3.R
import kotlinx.android.synthetic.main.second_fragment.*
import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList

class SecondFragment : Fragment(R.layout.second_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val exampleList = generateDummyList(17)
        list_id.adapter = ExampleAdapter(exampleList, context as AppCompatActivity)
        list_id.layoutManager = LinearLayoutManager(context)
        list_id.setHasFixedSize(true)

        var flag = true
        btnSearch.setOnClickListener {
            if (flag) {
                edtSearch.visibility = Group.VISIBLE
                flag = !flag
            } else if (edtSearch.text.equals("")) {
                edtSearch.visibility = Group.INVISIBLE
                flag = !flag
            }
        }
    }

    private fun generateDummyList(size: Int): List<ExampleItem> {
        val array = resources.getStringArray(R.array.titles)
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.article1
                1 -> R.drawable.article2
                else -> R.drawable.article
            }
            val item = ExampleItem(drawable, array[i], "Line 2")
            list += item
        }
        return list
    }
}