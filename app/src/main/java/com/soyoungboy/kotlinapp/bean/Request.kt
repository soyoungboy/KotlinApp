package com.soyoungboy.kotlinapp.bean

import java.net.URL

/**
 * Created by wfb on 2018/1/29.
 */
class Request(val url: String) {

    companion object {
        val BASE_URL = "http://gank.io/api/"
    }

    fun run(): String {
        val resultStr = URL(url).readText()
        return resultStr
    }
}