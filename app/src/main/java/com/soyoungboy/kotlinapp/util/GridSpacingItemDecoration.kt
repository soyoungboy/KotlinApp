package com.soyoungboy.kotlinapp.util

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * AndroidRecyclerviewGridLayoutManager列间距
 * Created by Wangfubin on 2017/11/28.
 */

class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        // item position
        val position = parent.getChildAdapterPosition(view)
        // item column
        val column = position % spanCount

        if (includeEdge) {
            // spacing - column * ((1f / spanCount) * spacing)
            outRect.left = spacing - column * spacing / spanCount
            // (column + 1) * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount

            // top edge

            if (position < spanCount) {
                outRect.top = spacing
            }
            // item bottom
            outRect.bottom = spacing
        } else {
            // column * ((1f / spanCount) * spacing)
            outRect.left = column * spacing / spanCount
            // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount
            if (position >= spanCount) {
                // item top
                outRect.top = spacing
            }
        }
    }
}
