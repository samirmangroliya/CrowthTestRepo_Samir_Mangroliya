package com.samir.crowthcodetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.samir.crowthcodetest.R
import com.samir.crowthcodetest.model.MainModel
import me.relex.circleindicator.CircleIndicator


class MainAdapter(private val listOfItems: MutableList<MainModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.search_and_options, parent, false)
                return SearchAndOptionHolder(itemView)
            }
            2 -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.campaign, parent, false)
                return CampaignHolder(itemView)
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.help_friends, parent, false)
                return HelpFriendsHolder(itemView)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return listOfItems[position].layoutType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            val mainModel = listOfItems[position]

            if (holder is CampaignHolder) {
                val listOfCampaign = mainModel.listOfCampaigns
                listOfCampaign?.let {
                    holder.viewPager.adapter = ViewPagerAdapter(listOfCampaign)
                    holder.circleIndicator.setViewPager(holder.viewPager)
                }
            } else if (holder is HelpFriendsHolder) {
                val listOfFriends = mainModel.listOfFriends
                listOfFriends?.let {
                    holder.recyclerView.adapter = HelpFriendAdapter(listOfFriends)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount() = listOfItems.size

    class SearchAndOptionHolder(view: View) : RecyclerView.ViewHolder(view)

    class CampaignHolder(view: View) : RecyclerView.ViewHolder(view) {
        val viewPager: ViewPager = view.findViewById(R.id.viewpager)
        val circleIndicator: CircleIndicator = view.findViewById(R.id.indicator)
    }

    class HelpFriendsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerviewhelpfriends)
    }

}