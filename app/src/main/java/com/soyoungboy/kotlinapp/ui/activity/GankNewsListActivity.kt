package com.soyoungboy.kotlinapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.soyoungboy.kotlinapp.R
import com.soyoungboy.kotlinapp.adapter.GankNewsAdapter
import com.soyoungboy.kotlinapp.bean.DataLoader
import com.soyoungboy.kotlinapp.bean.GankNews
import kotlinx.android.synthetic.main.activity_weath.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

/**
 * Created by wfb on 2018/1/29.
 */
//todo 刷新 ，加载更多
class GankNewsListActivity : AppCompatActivity() {
    private var page = 1
    private var news: ArrayList<GankNews>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weath)
        forecast_list.layoutManager = LinearLayoutManager(this)
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
        news!!.clear()
        page = 1
        async {
            val gankPictureList = DataLoader().getGankNewsList("data/all/20/" + page)
            uiThread {
                news!!.addAll(gankPictureList!!)
                forecast_list.adapter.notifyDataSetChanged()
                refreshLayout.finishRefresh()
            }
        }
    }

    /**
     * 加载更多
     */
    private fun loadMore() {
        async {
            var gankPictureList = DataLoader().getGankNewsList("data/all/20/" + page++)
            uiThread {
                news!!.addAll(gankPictureList!!)
                forecast_list.adapter.notifyDataSetChanged()
                refreshLayout.finishLoadmore()
            }
        }
    }

    private fun getGanksNewsList() = async {
         news = DataLoader().getGankNewsList("data/all/20/"+ page)
        uiThread {
            forecast_list.adapter = GankNewsAdapter(news!!) {
                val intent = Intent()
                intent.setClass(this@GankNewsListActivity, WebActivity::class.java)
                intent.putExtra("url", it.url)
                startActivity(intent)
            }
        }

    }

}