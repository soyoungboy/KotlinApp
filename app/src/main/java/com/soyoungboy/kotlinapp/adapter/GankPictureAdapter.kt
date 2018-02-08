package com.soyoungboy.kotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.soyoungboy.kotlinapp.R
import com.soyoungboy.kotlinapp.bean.GankPicture
import com.soyoungboy.kotlinapp.util.glide.ImageUtils
import kotlinx.android.synthetic.main.item_meizi.view.*
import org.jetbrains.anko.longToast

/**
 * Created by wfb on 2018/1/29.
 */
class GankPictureAdapter(val items: List<GankPicture>, val itemClickListener: (GankPicture) -> Unit) : RecyclerView.Adapter<GankPictureAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meizi, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val view: View, val itemClickListener: (GankPicture) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(pictures: GankPicture) {
            val meizi = view.meizi as ImageView
            ImageUtils.loadImage(pictures.url,meizi)
            view.title.text = pictures.desc
            view.setOnClickListener {
                itemClickListener(pictures)
                view.context.longToast(pictures.url)
            }
        }
    }
}