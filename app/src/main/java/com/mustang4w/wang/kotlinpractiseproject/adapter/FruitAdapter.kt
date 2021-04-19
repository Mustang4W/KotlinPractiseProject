package com.mustang4w.wang.kotlinpractiseproject.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mustang4w.wang.kotlinpractiseproject.entity.Fruit
import kotlinx.android.synthetic.main.item_fruit_list.view.*

class FruitAdapter(activity: Activity, private val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            viewHolder = ViewHolder(view.imgFruitImg, view.txtFruitName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        getItem(position)?.let {
            viewHolder.imgFruitImg.setImageResource(it.imageId)
            viewHolder.txtFruitName.text = it.name
        }
        return view
    }

    inner class ViewHolder(val imgFruitImg: ImageView, val txtFruitName: TextView)
}
