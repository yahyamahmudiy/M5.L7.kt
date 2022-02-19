package com.example.m5l7kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l7kt.Model.Feed
import com.example.m5l7kt.Model.Filter
import com.example.m5l7kt.Model.Home
import com.example.m5l7kt.Model.Shorts
import com.example.m5l7kt.R
import com.google.android.material.imageview.ShapeableImageView

class HomeAdapter(var context: Context, var items:ArrayList<Home>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var ITEM_FEED_SHORTS = 0
    private var ITEM_FEED_VIDEO = 1

    override fun getItemViewType(position: Int): Int {

        val item = items[position]

        if (item.shorts.size > 0)
            return ITEM_FEED_SHORTS
        return ITEM_FEED_VIDEO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_FEED_SHORTS) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feed_shorts_room, parent, false)
            return ShortsViewHolder(context,view)
        }else{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feed_video, parent, false)
            return VideoViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = items[position]

        if (holder is ShortsViewHolder){
            var recyclerView = holder.recyclerView
            refreshAdapter(recyclerView,filter.shorts)
        }

        if (holder is VideoViewHolder){
            val iv_profile = holder.iv_profile
            val iv_video = holder.iv_video

            iv_profile.setImageResource(filter.feed!!.profile)
            iv_video.setImageResource(filter.feed!!.photo)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    private fun refreshAdapter(recyclerView: RecyclerView, rooms: ArrayList<Shorts>) {
        val adapter = ShortsAdapter(context, rooms)
        recyclerView.adapter = adapter
    }

    class VideoViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_profile:ShapeableImageView
        var iv_video:ImageView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_video = view.findViewById(R.id.iv_video)
        }
    }
    private class ShortsViewHolder(context: Context, itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerViewFeed)

        init {
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}