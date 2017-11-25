package com.project.parallaxrecyclerview

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_cardview.*

/**
 * Created by sonseongbin on 2017. 11. 25..
 */
class CardViewFragment : Fragment() {

    private lateinit var adapter: CardViewAdapter
    private var headerHeight: Int = 0
    private var heightToScroll: Int = 0

    private var scrollY = 0
    private var translationY = 0

    private var listener: RecyclerViewScrollListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_cardview, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        headerHeight = arguments.getInt("headerHeight")
        heightToScroll = arguments.getInt("heightToScroll")

        adapter = CardViewAdapter(context, headerHeight)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                scrollY += dy

                translationY = scrollY

                if(heightToScroll < translationY) {
                    translationY = heightToScroll
                }

                if(translationY <= heightToScroll) {
                    listener?.onScrollHeader(-translationY)
                }

            }
        })
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as RecyclerViewScrollListener
    }

}