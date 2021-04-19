package com.mustang4w.wang.kotlinpractiseproject.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mustang4w.wang.kotlinpractiseproject.R

sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View) : MsgViewHolder(view) {
    val txtLeft: TextView = view.findViewById(R.id.txtLeftMessage)
}

class RightViewHolder(view: View) : MsgViewHolder(view) {
    val txtRight: TextView = view.findViewById(R.id.txtRightMessage)
}

