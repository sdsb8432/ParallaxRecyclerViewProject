package com.project.parallaxrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by sonseongbin on 2017. 11. 25..
 */
class CardViewAdapter(private val context: Context, private val headerHeight: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HEADER = 0
    private val ITEM = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if(getItemViewType(position) == HEADER) {

        }
        else {
            val itemHolder = holder as ViewHolder
            itemHolder.textView.text = "text$position"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder =
        when(viewType) {
            HEADER -> {
                val view = View(context)
                view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, headerHeight)
                ViewHolder(view)
            }
            else -> {
                ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_card, parent, false))
            }
        }

    override fun getItemCount(): Int = 100

    override fun getItemViewType(position: Int): Int =
            when(position) {
                0 -> HEADER
                else -> ITEM
            }
}