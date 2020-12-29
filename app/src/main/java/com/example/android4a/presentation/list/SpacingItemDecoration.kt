package com.example.android4a.presentation.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

//Adding padding to the items in the list
class SpacingItemDecoration (private val padding: Int) : RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = padding
    }
}