package com.soyoungboy.kotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.soyoungboy.kotlinapp.R
import com.soyoungboy.kotlinapp.bean.GankNews
import com.soyoungboy.kotlinapp.util.DateUtil
import com.soyoungboy.kotlinapp.util.glide.ImageUtils
import kotlinx.android.synthetic.main.item_gank_news.view.*

/**
 * Created by wfb on 2018/1/29.
 */
class GankNewsAdapter(val items: List<GankNews>, val itemClickListener: (GankNews) -> Unit) : RecyclerView.Adapter<GankNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gank_news, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val view: View, val itemClickListener: (GankNews) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(news: GankNews) {
            Log.i("CurrentTime", DateUtil.nowDate)
            val imageview2 = view.imageview2 as ImageView
            if (news.images != null && news.images.isNotEmpty()) {
                ImageUtils.loadImage(news.images[0], imageview2)
                imageview2.visibility = View.VISIBLE
            } else {
                imageview2.visibility = View.GONE
            }
            val imageview1 = view.imageview1 as ImageView
            if (news.url.endsWith(".jpg")) {
                ImageUtils.loadImage(news.url, imageview1)
                imageview1.visibility = View.VISIBLE
            } else {
                imageview1.visibility = View.GONE
            }
            view.content.text = news.desc
            view.createdAt.text = news.createdAt
            view.who.text = news.who
            view.setOnClickListener {
                itemClickListener(news)
            }
        }
    }
}
