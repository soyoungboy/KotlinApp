package com.soyoungboy.kotlinapp.util.glide;

import android.view.View;

import com.bumptech.glide.request.RequestOptions;

/**
 * Created by dell on 2017/7/19.
 *
 * 用于对外提供图片加载服务
 *
 * 图片加载框架的替换.
 */

public class ImageLoaderStrategyManager implements ImageloaderStrategy {

    private static ImageLoaderStrategyManager INSTANCE = new ImageLoaderStrategyManager();

    private ImageloaderStrategy imageloader ;

    public static ImageLoaderStrategyManager getInstance(){
        return INSTANCE;
    }
    /**
     * 默认使用Glide 加载图片
     */
    private ImageLoaderStrategyManager(){
        imageloader = new GlideImageloaderStrategy();
    }

    /**
     * 提供图片加载框架替换接口
     * @param loader
     */
    private void setImageloader(ImageloaderStrategy loader){
        if (loader != null){
            this.imageloader = loader;
        }
    }

    @Override
    public void showImage(View v, String url, RequestOptions options) {
        imageloader.showImage(v,url,options);
    }

    @Override
    public void showImage(View v, int id, RequestOptions options) {
        imageloader.showImage(v,id,options);
    }
}
