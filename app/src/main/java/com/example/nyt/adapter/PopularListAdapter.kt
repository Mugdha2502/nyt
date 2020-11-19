package com.example.nyt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nyt.R
import com.example.nyt.data.Data
import com.example.nyt.ui.main.view.ResulttemViewHolder

class PopularListAdapter(val mostPopularItemList: List<Data>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ResulttemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mostPopularItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ResulttemViewHolder).bind(mostPopularItemList.get(position).title!!,
            mostPopularItemList.get(position).date,
            mostPopularItemList.get(position).source!!)
    }
}