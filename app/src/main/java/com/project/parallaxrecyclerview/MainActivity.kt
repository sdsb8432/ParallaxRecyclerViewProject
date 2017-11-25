package com.project.parallaxrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewScrollListener {

    private var heightToScroll = 0

    private val recyclerViewFragment = RecyclerViewFragment()
    private val cardViewFragment = CardViewFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)

        heightToScroll = headerView.measuredHeight - tab.measuredHeight

        clickTab01()

        tab01.setOnClickListener {
            clickTab01()
        }

        tab02.setOnClickListener {
            clickTab02()
        }

    }

    private fun clickTab01() {

        val args = Bundle()

        args.putInt("headerHeight", headerView.measuredHeight)
        args.putInt("heightToScroll", heightToScroll)

        recyclerViewFragment.arguments = args

        supportFragmentManager.beginTransaction().replace(R.id.layout_fragment, recyclerViewFragment).commit()
    }

    private fun clickTab02() {
        val args = Bundle()

        args.putInt("headerHeight", headerView.measuredHeight)
        args.putInt("heightToScroll", heightToScroll)

        cardViewFragment.arguments = args

        supportFragmentManager.beginTransaction().replace(R.id.layout_fragment, cardViewFragment).commit()
    }

    override fun onScrollHeader(scrollY: Int) {
        headerView.translationY = scrollY.toFloat()
    }
}