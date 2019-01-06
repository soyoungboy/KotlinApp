package com.soyoungboy.kotlinapp.bean

/**
 * Created by wfb on 2018/1/29.
 */
data class GankPicture(
        var _id: String,
        var createdAt: String,
        var desc: String,
        var publishedAt: String,
        var source: String,
        var type: String,
        var url: String,
        var used: Boolean,
        var who: String


)