package com.soyoungboy.kotlinapp.bean

import com.soyoungboy.kotlinapp.util.json.Json

/**
 * Created by soyoungboy on 2018/1/29.
 */
class DataLoader {

    fun getGankNewsList(date: String): List<GankNews> {
        val url = Request.BASE_URL + date
        return Json.get().toObject(Request(url).run(), GankNewsList::class.java).results
    }

    fun getGankPictureList(date: String): ArrayList<GankPicture> {
        val url = Request.BASE_URL + date
        return Json.get().toObject(Request(url).run(), GankPictureList::class.java).results
    }
}
