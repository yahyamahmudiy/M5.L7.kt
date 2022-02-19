package com.example.m5l7kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l7kt.Model.Shorts
import com.example.m5l7kt.R

class ShortsAdapter(var context: Context, var items:ArrayList<Shorts>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_shorts,parent,false)
        return ShortsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = items[position]

        if (holder is ShortsViewHolder){
            val iv_photo = holder.iv_photo
            val tv_description = holder.tv_description
            val tv_view = holder.tv_view

            iv_photo.setImageResource(video.photo)
            tv_description.text = video.description
            tv_view.text = video.views
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ShortsViewHolder(view: View):RecyclerView.ViewHolder(view){
        var iv_photo:ImageView
        var tv_description:TextView
        var tv_view:TextView

        init {
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_description = view.findViewById(R.id.tv_description)
            tv_view = view.findViewById(R.id.tv_view)
        }
    }
}