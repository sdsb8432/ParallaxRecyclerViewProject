package com.project.parallaxrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by sonseongbin on 2017. 11. 25..
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView by lazy {
        itemView.findViewById<TextView>(R.id.textView)
    }
}