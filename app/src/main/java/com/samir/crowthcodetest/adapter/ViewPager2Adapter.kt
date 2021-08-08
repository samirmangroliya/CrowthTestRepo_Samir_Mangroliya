package com.samir.crowthcodetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samir.crowthcodetest.model.Campaign
import com.samir.crowthcodetest.R

internal class ViewPager2Adapter
    (private val listOfCampaign: MutableList<Campaign>) :
    RecyclerView.Adapter<ViewPager2Adapter.CampaignHolder>() {


    // This method returns our layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_campaign, parent, false)
        return CampaignHolder(view)
    }

    // This method binds the screen with the view
    override fun onBindViewHolder(holder: CampaignHolder, position: Int) {
        val campaign = listOfCampaign[position]
        holder.tvTitle.text = campaign.name
    }

    // This Method returns the size of the Array
    override fun getItemCount() = listOfCampaign.size

    // The ViewHolder class holds the view
    class CampaignHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvinterested)
    }
}