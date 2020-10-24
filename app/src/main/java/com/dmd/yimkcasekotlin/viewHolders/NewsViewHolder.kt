package com.dmd.yimkcasekotlin.viewHolders

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dmd.yimkcasekotlin.R
import com.dmd.yimkcasekotlin.activities.DetailsActivity
import com.dmd.yimkcasekotlin.models.News
import com.squareup.picasso.Picasso


class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_news, parent, false)) {
    private var mTitleView: TextView? = null
    private var mImageView: ImageView? = null

    init {
        mTitleView = itemView.findViewById(R.id.txtNewsHeader)
        mImageView = itemView.findViewById(R.id.itemImageView)
    }

    fun bind(news: News) {
        mTitleView?.text = news.title
        Picasso.get().load(news.imageUrl).into(mImageView);

        itemView.setOnClickListener {
            val detailsIntent = Intent(itemView.context, DetailsActivity::class.java)
            detailsIntent.putExtra("objectToDetails",news)
            itemView.context.startActivity(detailsIntent)

        }
    }

}