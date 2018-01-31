package com.soyoungboy.kotlinapp.widget

/**
 * Created by wfb on 2018/1/30.
 */

import android.content.Context
import android.util.AttributeSet
import android.view.View

class RatioImageView : android.support.v7.widget.AppCompatImageView {

    private var originalWidth: Int = 0
    private var originalHeight: Int = 0


    constructor(context: Context) : super(context) {}


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}


    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    fun setOriginalSize(originalWidth: Int, originalHeight: Int) {
        this.originalWidth = originalWidth
        this.originalHeight = originalHeight
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (originalWidth > 0 && originalHeight > 0) {
            val ratio = originalWidth.toFloat() / originalHeight.toFloat()

            val width = View.MeasureSpec.getSize(widthMeasureSpec)
            var height = View.MeasureSpec.getSize(heightMeasureSpec)
            // TODO: 现在只支持固定宽度
            if (width > 0) {
                height = (width.toFloat() / ratio).toInt()
            }

            setMeasuredDimension(width, height)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
