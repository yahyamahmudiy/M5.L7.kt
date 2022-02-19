package com.example.m5l7kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l7kt.Model.Feed
import com.example.m5l7kt.Model.Filter
import com.example.m5l7kt.R
import com.google.android.material.imageview.ShapeableImageView

class FilterAdapter(var context: Context, var items:ArrayList<Filter>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var ITEM_FEED_EXPLORE = 0
    private var ITEM_FEED_FILTER = 1

    override fun getItemViewType(position: Int): Int {

        if (position == 0)
            return ITEM_FEED_EXPLORE
        return ITEM_FEED_FILTER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_FEED_EXPLORE) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feed_filter_explore, parent, false)
            return FilterViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_feed_filter, parent, false)
            return FilterViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = items[position]

        if (holder is FilterViewHolder){
            var tv_title = holder.tv_title

            tv_title.text = filter.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FilterViewHolder(view: View):RecyclerView.ViewHolder(view){
        var tv_title:TextView


        init {
            tv_title = view.findViewById(R.id.tv_title)
        }
    }
}