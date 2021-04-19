package com.mustang4w.wang.kotlinpractiseproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mustang4w.wang.kotlinpractiseproject.adapter.viewholder.LeftViewHolder
import com.mustang4w.wang.kotlinpractiseproject.adapter.viewholder.MsgViewHolder
import com.mustang4w.wang.kotlinpractiseproject.R
import com.mustang4w.wang.kotlinpractiseproject.adapter.viewholder.RightViewHolder
import com.mustang4w.wang.kotlinpractiseproject.entity.ChatMessageEntity

class UI9PatchAdapter(private val data: ArrayList<ChatMessageEntity>) : RecyclerView.Adapter<MsgViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        return if (viewType == ChatMessageEntity.TYPE_RECEIVED) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_left_message, parent, false)
            LeftViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_right_message, parent, false)
            RightViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val entity = data[position]
        when (holder) {
            is LeftViewHolder -> holder.txtLeft.text = entity.content
            is RightViewHolder -> holder.txtRight.text = entity.content
        }
    }

    override fun getItemViewType(position: Int): Int = data[position].type

    override fun getItemCount(): Int = data.size
}