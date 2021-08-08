package com.samir.crowthcodetest.viewmodel

import androidx.lifecycle.ViewModel
import com.samir.crowthcodetest.model.Campaign
import com.samir.crowthcodetest.model.Friend
import com.samir.crowthcodetest.model.MainModel

class MainViewModel : ViewModel() {
    fun getPageData(): ArrayList<MainModel> {
        val listOfItems = ArrayList<MainModel>()

        //add dummy campain here
        val campaign1 = Campaign("Black Lives Matter 1", "25-June-2021")
        val campaign2 = Campaign("Black Lives Matter 2", "26-June-2021")
        val campaign3 = Campaign("Black Lives Matter 3", "27-June-2021")

        val listOfCampaign = ArrayList<Campaign>()
        listOfCampaign.add(campaign1)
        listOfCampaign.add(campaign2)
        listOfCampaign.add(campaign3)

        //add dummy friends
        val friend1 = Friend("Maya is interested in", "Sr. Business Manager", "Chief of Staff", "London", "Remote", null, null)
        val friend2 =
            Friend("Gabriela is interested in", "Flutter Developer", null, "London", "Remote", "€ 400 /day", 100)
        val friend3 = Friend("Maya is interested in", "Sr. Business Manager", "Chief of Staff", "London", "Remote", null, null)

        val listOfFriends = ArrayList<Friend>()
        listOfFriends.add(friend1)
        listOfFriends.add(friend2)
        listOfFriends.add(friend3)


        val searchAndOption = MainModel(1, null, null)
        val campaigns = MainModel(2, listOfCampaign, null)
        val friends = MainModel(3, null, listOfFriends)

        listOfItems.add(searchAndOption)
        listOfItems.add(campaigns)
        listOfItems.add(friends)
        listOfItems.add(friends)

        return listOfItems
    }

}