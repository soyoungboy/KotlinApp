package com.soyoungboy.kotlinapp.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by soyoungboy on 2018/1/31.
 */

object SharedPreferencesUtil {
    fun getPrefString(context: Context, key: String,
                      defaultValue: String): String? {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        return settings.getString(key, defaultValue)
    }


    fun setPrefString(context: Context, key: String,
                      value: String) {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        settings.edit().putString(key, value).apply()
    }


    fun getPrefBoolean(context: Context, key: String,
                       defaultValue: Boolean): Boolean {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        return settings.getBoolean(key, defaultValue)
    }


    fun hasKey(context: Context, key: String): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .contains(key)
    }


    fun setPrefBoolean(context: Context, key: String,
                       value: Boolean) {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        settings.edit().putBoolean(key, value).apply()
    }


    fun setPrefInt(context: Context, key: String,
                   value: Int) {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        settings.edit().putInt(key, value).apply()
    }


    fun getPrefInt(context: Context, key: String,
                   defaultValue: Int): Int {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        return settings.getInt(key, defaultValue)
    }


    fun setPrefFloat(context: Context, key: String,
                     value: Float) {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        settings.edit().putFloat(key, value).apply()
    }


    fun getPrefFloat(context: Context, key: String,
                     defaultValue: Float): Float {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        return settings.getFloat(key, defaultValue)
    }


    fun setSettingLong(context: Context, key: String,
                       value: Long) {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        settings.edit().putLong(key, value).apply()
    }


    fun getPrefLong(context: Context, key: String,
                    defaultValue: Long): Long {
        val settings = PreferenceManager.getDefaultSharedPreferences(context)
        return settings.getLong(key, defaultValue)
    }


    fun clearPreference(context: Context,
                        p: SharedPreferences) {
        val editor = p.edit()
        editor.clear()
        editor.apply()
    }
}
