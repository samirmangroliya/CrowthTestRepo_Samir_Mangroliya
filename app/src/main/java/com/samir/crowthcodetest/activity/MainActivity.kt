package com.samir.crowthcodetest.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.samir.crowthcodetest.R
import com.samir.crowthcodetest.adapter.MainAdapter
import com.samir.crowthcodetest.databinding.ActivityMainBinding
import com.samir.crowthcodetest.model.MainModel
import com.samir.crowthcodetest.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter
    private var listOfItems = ArrayList<MainModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()
        setUpRecyclerView()

    }

    private fun init() {
        setSupportActionBar(binding.toolbar)
        recyclerView = binding.contentmain.recyclerview
        mainAdapter = MainAdapter(listOfItems)
        recyclerView.adapter = mainAdapter
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }


    private fun setUpRecyclerView() {
        listOfItems = mainViewModel.getPageData()
        mainAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_chat -> true
            R.id.action_menu -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}