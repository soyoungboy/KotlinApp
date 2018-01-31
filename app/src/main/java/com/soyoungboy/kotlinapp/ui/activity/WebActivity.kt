package com.soyoungboy.kotlinapp.ui.activity

/**
 * Created by wfb on 2018/1/29.
 */

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView

import com.just.agentweb.BaseAgentWebActivity
import com.soyoungboy.kotlinapp.R

class WebActivity : BaseAgentWebActivity() {

    private var mTitleTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_layout)
        val mToolbar = this.findViewById<Toolbar>(R.id.toolbar)
        mToolbar.setTitleTextColor(Color.WHITE)
        mToolbar.title = ""
        mTitleTextView = this.findViewById(R.id.toolbar_title)
        this.setSupportActionBar(mToolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        mToolbar.setNavigationOnClickListener {
            this@WebActivity.finish()
            //                onKeyDown(KeyEvent.KEYCODE_BACK,new KeyEvent(KeyEvent.ACTION_UP,KeyEvent.KEYCODE_BACK));
        }
    }


    override fun getAgentWebParent(): ViewGroup {
        return this.findViewById<View>(R.id.container) as ViewGroup
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (mAgentWeb != null && mAgentWeb.handleKeyEvent(keyCode, event)) {
            true
        } else super.onKeyDown(keyCode, event)

    }

    override fun setTitle(view: WebView, title: String) {
        mTitleTextView!!.text = title
    }

    override fun getIndicatorColor(): Int {
        return Color.parseColor("#ff0000")
    }

    override fun getIndicatorHeight(): Int {
        return 3
    }

    override fun getUrl(): String {
        return intent.getStringExtra("url")
    }
}
