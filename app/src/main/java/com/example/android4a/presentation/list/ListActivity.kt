package com.example.android4a.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android4a.R
import com.example.android4a.data.local.DataSource
import com.example.android4a.domain.entity.KKSong
import com.example.android4a.presentation.list.ListViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.ext.android.inject

class ListActivity: AppCompatActivity() {
    val listViewModel : ListViewModel by inject()
    private lateinit var kksongAdapter : KKSongsRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        listViewModel.makeApiCall()
        listViewModel.apiCallLiveData.observe(this, {
            when(it){
                is APICallSuccess -> {
                    initRecyclerView()
                    addDataSet(it.kkSongList)
                }
                APICallError -> {
                    MaterialAlertDialogBuilder(this).setTitle("API Call Error").setMessage("Couldn't make API Call").setPositiveButton("Ok"){ dialog,
                                                                                                                                       which-> dialog.dismiss()}.show()
                }
            }
        })


    }

    private fun addDataSet(kkSongList: List<KKSong>){
        //val data = DataSource.createDataSet()
        val data = kkSongList
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