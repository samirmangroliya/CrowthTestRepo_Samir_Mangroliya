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
import com.samir.crowthcodetest.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        init()
        setUpRecyclerView()

    }

    private fun init() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        recyclerView = binding.contentmain.recyclerview

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }


    private fun setUpRecyclerView() {
        mainAdapter = MainAdapter(mainViewModel.getPageData())
        recyclerView.adapter = mainAdapter
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