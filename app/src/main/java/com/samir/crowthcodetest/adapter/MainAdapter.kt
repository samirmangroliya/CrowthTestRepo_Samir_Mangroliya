package com.samir.crowthcodetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.samir.crowthcodetest.model.MainModel
import com.samir.crowthcodetest.R

class MainAdapter(val listOfItems: MutableList<MainModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            val mainModel = listOfItems[position]

            if (holder is CampaignHolder) {
                val listOfCampaign = mainModel.listOfCampaigns
                listOfCampaign?.let {
                    holder.viewPager2.adapter = ViewPager2Adapter(listOfCampaign)
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

    class SearchAndOptionHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class CampaignHolder(view: View) : RecyclerView.ViewHolder(view) {
        val viewPager2: ViewPager2 = view.findViewById(R.id.viewpager2)
    }

    class HelpFriendsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerviewhelpfriends)
    }

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
}