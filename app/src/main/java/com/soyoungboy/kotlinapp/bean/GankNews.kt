package com.soyoungboy.kotlinapp.bean

/**
 * Created by soyoungboy on 2018/1/29.
 */
data class GankNews(val _id: String,
                    val createdAt: String,
                    val desc: String,
                    val publishedAt: String,
                    val type: String,
                    val url: String,
                    val used: Boolean,
                    val who: String)