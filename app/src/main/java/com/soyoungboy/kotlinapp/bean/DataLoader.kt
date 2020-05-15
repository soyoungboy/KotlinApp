package com.soyoungboy.kotlinapp.bean

import com.soyoungboy.kotlinapp.util.json.Json
import java.util.*

/**
 * Created by soyoungboy on 2018/1/29.
 */
class DataLoader {

    fun getGankNewsList(date: String): ArrayList<GankNews> {
        val url = Request.BASE_URL + date
        return Json.get().toObject(Request(url).run(), GankNewsList::class.java).results
    }

    fun getGankPictureList(date: String): ArrayList<GankPicture> {
        //https://gank.io/api/data/福利/10/1
        val url = Request.BASE_URL + date
        return Json.get().toObject(Request(url).run(), GankPictureList::class.java).results
    }
}
