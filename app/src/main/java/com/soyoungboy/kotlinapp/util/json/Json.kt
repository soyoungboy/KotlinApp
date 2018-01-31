package com.soyoungboy.kotlinapp.util.json

abstract class Json internal constructor() {


    abstract fun toJson(src: Any): String

    abstract fun <T> toObject(json: String, claxx: Class<T>): T

    abstract fun <T> toObject(bytes: ByteArray, claxx: Class<T>): T

    abstract fun <T> toList(json: String, claxx: Class<T>): List<T>?

    companion object {
        private var json: Json? = null


        fun get(): Json {
            if (json == null) {
                json = GsonImpl()
            }
            return json as Json
        }
    }
}
