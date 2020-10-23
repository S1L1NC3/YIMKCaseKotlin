package com.dmd.yimkcasekotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmd.yimkcasekotlin.viewHolders.NewsViewHolder
import com.dmd.yimkcasekotlin.models.News

class NewsAdapter(private val dataList: ArrayList<News>): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: News = dataList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(newDataList: ArrayList<News>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}