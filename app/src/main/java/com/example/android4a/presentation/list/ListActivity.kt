package com.example.android4a.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android4a.R
import com.example.android4a.data.local.DataSource
import com.example.android4a.presentation.list.ListViewModel
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject

class ListActivity: AppCompatActivity() {
    val listViewModel : ListViewModel by inject()
    private lateinit var kksongAdapter : KKSongsRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        kksongAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            val spacingItemDecoration = SpacingItemDecoration(20)
            addItemDecoration(spacingItemDecoration)
            kksongAdapter = KKSongsRecyclerViewAdapter()
            recycler_view.adapter = kksongAdapter
        }
    }
}