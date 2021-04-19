package com.mustang4w.wang.kotlinpractiseproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mustang4w.wang.kotlinpractiseproject.R
import com.mustang4w.wang.kotlinpractiseproject.entity.Fruit

class FruitRecyclerViewAdapter(private val data: ArrayList<Fruit>) : RecyclerView.Adapter<FruitRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fruit_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fruitImage.setImageResource(data[position].imageId)
        holder.fruitName.text = data[position].name
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitImage: ImageView = itemView.findViewById(R.id.imgFruitImg)
        val fruitName: TextView = itemView.findViewById(R.id.txtFruitName)
    }
}