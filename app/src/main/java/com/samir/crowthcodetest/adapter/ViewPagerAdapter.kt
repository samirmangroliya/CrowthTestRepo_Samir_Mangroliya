package com.samir.crowthcodetest.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.samir.crowthcodetest.R
import com.samir.crowthcodetest.model.Campaign

class ViewPagerAdapter(private val listOfCampaign: MutableList<Campaign>) : PagerAdapter() {
    override fun getCount() = listOfCampaign.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.item_campaign, container, false) as ViewGroup
        val tvTitle: TextView = view.findViewById(R.id.tvtitle)
        val campaign = listOfCampaign[position]
        tvTitle.text = campaign.name
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}