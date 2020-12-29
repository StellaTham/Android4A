package com.example.android4a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android4a.R
import com.example.android4a.domain.entity.KKSong
import kotlinx.android.synthetic.main.details_item.view.*

class KKSongsRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<KKSong> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return KKSongViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.details_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is KKSongViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    fun submitList(kksongList:List<KKSong>){
        items = kksongList
    }
    class KKSongViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val kksong_name = itemView.kksong_name
        val kksong_image = itemView.kksong_image

        fun bind(kkSong: KKSong){
            kksong_name.text = kkSong.name

            //Basic Request Options to handle Glide
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            //Using Glide to display images from URL
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(kkSong.image)
                .into(kksong_image)
        }

    }
}