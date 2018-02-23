package com.soyoungboy.kotlinapp.util.json

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * Created by soyoungboy on 2017/12/25.
 */

class GsonImpl : Json() {
    private val gson = Gson()


    override fun toJson(src: Any): String {
        return gson.toJson(src)
    }


    override fun <T> toObject(json: String, claxx: Class<T>): T {
        return gson.fromJson(json, claxx)
    }


    override fun <T> toObject(bytes: ByteArray, claxx: Class<T>): T {
        return gson.fromJson(String(bytes), claxx)
    }


    override fun <T> toList(json: String, claxx: Class<T>): List<T>? {
        val type = object : TypeToken<ArrayList<T>>() {

        }.type
        return gson.fromJson<List<T>>(json, type)
    }

}
