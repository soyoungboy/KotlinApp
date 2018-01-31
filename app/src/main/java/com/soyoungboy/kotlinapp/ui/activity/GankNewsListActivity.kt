package com.soyoungboy.kotlinapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.soyoungboy.kotlinapp.R
import com.soyoungboy.kotlinapp.adapter.GankNewsAdapter
import com.soyoungboy.kotlinapp.bean.DataLoader
import kotlinx.android.synthetic.main.activity_weath.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

/**
 * Created by wfb on 2018/1/29.
 */
class GankNewsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weath)
        forecast_list.layoutManager = LinearLayoutManager(this)
        getGanksNewsList()
    }

    private fun getGanksNewsList() = async {
        val news = DataLoader().getGankNewsList("data/all/20/2")
        uiThread {
            forecast_list.adapter = GankNewsAdapter(news) {
                val intent = Intent()
                intent.setClass(this@GankNewsListActivity, WebActivity::class.java)
                intent.putExtra("url", it.url)
                startActivity(intent)
            }
        }

    }

}