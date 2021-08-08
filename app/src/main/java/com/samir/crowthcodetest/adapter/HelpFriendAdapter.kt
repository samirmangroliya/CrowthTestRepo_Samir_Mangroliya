package com.samir.crowthcodetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samir.crowthcodetest.model.Friend
import com.samir.crowthcodetest.R

class HelpFriendAdapter(val listOfFriends: MutableList<Friend>) : RecyclerView.Adapter<HelpFriendAdapter.HelpFriendsHolder>() {


    override fun onBindViewHolder(holder: HelpFriendsHolder, position: Int) {
        try {
            val friend = listOfFriends[position]
            holder.tvInterested.text = friend.interest
            holder.tvjob.text = friend.job
            holder.tvlocation.text = friend.location
            holder.tvjobtype.text = friend.jobType


            friend.designation?.let {
                holder.tvdesignation.text = friend.designation
                holder.tvdesignation.visibility = View.VISIBLE
                holder.llEarnings.visibility = View.GONE
            } ?: run {
                holder.tvdesignation.visibility = View.GONE
                holder.llEarnings.visibility = View.VISIBLE
                holder.tvEarningPerDay.text = friend.earningPerDay
                holder.tvPercentage.text = "${friend.percentage} %"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount() = listOfFriends.size

    class HelpFriendsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvInterested: TextView = view.findViewById(R.id.tvinterested)
        val tvjob: TextView = view.findViewById(R.id.tvjob)
        val tvdesignation: TextView = view.findViewById(R.id.tvdesignation)
        val tvlocation: TextView = view.findViewById(R.id.tvlocation)
        val tvjobtype: TextView = view.findViewById(R.id.tvjobtype)
        val llEarnings: LinearLayout = view.findViewById(R.id.llearnings)
        val tvEarningPerDay: TextView = view.findViewById(R.id.tvearningperday)
        val tvPercentage: TextView = view.findViewById(R.id.tvpercentage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpFriendsHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_help_friends, parent, false)
        return HelpFriendsHolder(itemView)
    }

}