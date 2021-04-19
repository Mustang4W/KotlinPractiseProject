package com.mustang4w.wang.kotlinpractiseproject.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.mustang4w.wang.kotlinpractiseproject.R
import com.mustang4w.wang.kotlinpractiseproject.adapter.FruitAdapter
import com.mustang4w.wang.kotlinpractiseproject.entity.Fruit
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : BaseActivity() {

    private val fruitList = ArrayList<Fruit>()

    companion object {
        @JvmStatic
        fun actionStart(context: Context) {
            context.startActivity(Intent(context, ListViewActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        initFruits()

        val adapter = FruitAdapter(this, R.layout.item_fruit_list, fruitList)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }
}
