package com.example.m5l7kt.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5l7kt.Adapter.ShortsAdapter
import com.example.m5l7kt.Adapter.FilterAdapter
import com.example.m5l7kt.Adapter.HomeAdapter
import com.example.m5l7kt.Model.Feed
import com.example.m5l7kt.Model.Filter
import com.example.m5l7kt.Model.Home
import com.example.m5l7kt.Model.Shorts
import com.example.m5l7kt.R

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewFilter: RecyclerView
    lateinit var recyclerViewFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews(){
        recyclerViewFilter = findViewById(R.id.recyclerView)
        recyclerViewFilter.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))

        recyclerViewFeed = findViewById(R.id.recyclerViewFeed)
        recyclerViewFeed.setLayoutManager(GridLayoutManager(this,1))

        refreshAdapterHome(getAllFeeds())
        refreshAdapterStory(getAllFilters())
    }
    fun refreshAdapterStory(chats:ArrayList<Filter>){
        val adapter = FilterAdapter(this,chats)
        recyclerViewFilter.adapter = adapter
    }
    fun refreshAdapterHome(chats:ArrayList<Home>){
        val adapter = HomeAdapter(this,chats)
        recyclerViewFeed.adapter = adapter
    }

    fun getAllFilters():ArrayList<Filter>{
        val filters:ArrayList<Filter> = ArrayList()

        filters.add(Filter("Explore"))
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))

        return filters
    }
    fun getAllFeeds():ArrayList<Home>{

        val shorts:ArrayList<Shorts> = ArrayList()

        shorts.add(Shorts(R.drawable.img_2,"16-fevralda urush boshlanadimi?!","107K views"))
        shorts.add(Shorts(R.drawable.img_2,"16-fevralda urush boshlanadimi?!","107K views"))
        shorts.add(Shorts(R.drawable.img_2,"16-fevralda urush boshlanadimi?!","107K views"))

        val home:ArrayList<Home> = ArrayList()

        home.add(Home(Feed(R.drawable.img_3, R.drawable.img_1)))

        home.add(Home(shorts = shorts))

        home.add(Home(Feed(R.drawable.img_3, R.drawable.img_1)))
        home.add(Home(Feed(R.drawable.img_3, R.drawable.img_1)))
        home.add(Home(Feed(R.drawable.img_3, R.drawable.img_1)))

        return home

    }
}