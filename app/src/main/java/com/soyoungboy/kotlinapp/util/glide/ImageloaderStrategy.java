package com.soyoungboy.kotlinapp.util.glide;

import android.view.View;

import com.bumptech.glide.request.RequestOptions;

/**
 * Created by dell on 2017/7/19.
 */

public interface ImageloaderStrategy {

    void showImage(View v, String url, RequestOptions options);

    void showImage(View v, int id, RequestOptions options);
}
