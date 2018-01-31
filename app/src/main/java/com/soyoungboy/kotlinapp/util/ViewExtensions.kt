package com.soyoungboy.kotlinapp.util

import android.content.Context
import android.view.View

/**
 * Created by wfb on 2018/1/29.
 */
class ViewExtensions {
    val View.ctx: Context get() = context
}