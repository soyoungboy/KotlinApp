package com.soyoungboy.kotlinapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.soyoungboy.kotlinapp.R
import com.soyoungboy.kotlinapp.adapter.GankPictureAdapter
import com.soyoungboy.kotlinapp.bean.DataLoader
import com.soyoungboy.kotlinapp.bean.GankPicture
import com.soyoungboy.kotlinapp.util.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_picture.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

/**
 * Created by wfb on 2018/1/30.
 */

class GankPictureActivity : AppCompatActivity() {
    private var page = 1
    private val spanCount = 2
    private var pictures: ArrayList<GankPicture>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)
        recyclerview.addItemDecoration(GridSpacingItemDecoration(spanCount, resources.getDimensionPixelSize(R.dimen.dp_10), true))
        recyclerview.layoutManager = GridLayoutManager(refreshLayout.context, spanCount)
        getGanksNewsList()
        refreshLayout.setEnableAutoLoadmore(true)
        refreshLayout.setOnRefreshListener {
            refresh()
        }

        refreshLayout.setOnLoadmoreListener {
            loadMore()
        }
    }


    /**
     * 刷新
     */
    private fun refresh() {
        pictures!!.clear()
        page = 1
        async {
            val gankPictureList = DataLoader().getGankPictureList("data/福利/20/" + page)
            uiThread {
                pictures!!.addAll(gankPictureList!!)
                recyclerview.adapter.notifyDataSetChanged()
                refreshLayout.finishRefresh()
            }
        }
    }

    /**
     * 加载更多
     */
    private fun loadMore() {
        async {
            var gankPictureList = DataLoader().getGankPictureList("data/福利/20/" + page++)
            uiThread {
                pictures!!.addAll(gankPictureList!!)
                recyclerview.adapter.notifyDataSetChanged()
                refreshLayout.finishLoadmore()
            }
        }
    }


    private fun getGanksNewsList() = async {
        pictures = DataLoader().getGankPictureList("data/福利/10/" + page)

        uiThread {
            recyclerview.adapter = GankPictureAdapter(pictures!!) {
                val intent = Intent()
                intent.setClass(this@GankPictureActivity, WebActivity::class.java)
                intent.putExtra("url", it.url)
                startActivity(intent)
            }

        }

    }
}
