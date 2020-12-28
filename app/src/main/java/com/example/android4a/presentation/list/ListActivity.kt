package com.example.android4a.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android4a.R
import com.example.android4a.presentation.main.MainViewModel
import org.koin.android.ext.android.inject

class ListActivity: AppCompatActivity() {
    val listViewModel : ListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

    }
}