package com.soyoungboy.kotlinapp.util.glide;

import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.soyoungboy.kotlinapp.R;


/**
 * Created by dell on 2016/5/28.
 * <p/>
 * 加载图片的工具类
 */
public class ImageUtils {

    /**
     * 使用Glide 加载网络图片
     * @param url
     * @param imageView
     */
    public static void loadImage(String url, final ImageView imageView){
        ImageLoaderStrategyManager imageLoader = ImageLoaderStrategyManager.getInstance();

        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.default_news_cat_pic)
                .error(R.mipmap.default_news_cat_pic)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        // 根据夜间模式标记， 判断是否给图片添加 滤镜
        options.transform(new CenterCrop());
        imageLoader.showImage(imageView,url,options);
    }

    public static void loadImage(String url, final ImageView imageView , RequestOptions options){
        ImageLoaderStrategyManager imageLoader = ImageLoaderStrategyManager.getInstance();

        imageLoader.showImage(imageView,url,options);
    }

    /**
     *
     * @param url
     * @param imageView
     * @param id 占位图资源id
     */
    public static void loadImage(String url, ImageView imageView , int id){
        ImageLoaderStrategyManager imageLoader = ImageLoaderStrategyManager.getInstance();

        RequestOptions options = new RequestOptions();
        options.placeholder(id);
        options.error(id);
        options.transform(new CenterCrop());
        imageLoader.showImage(imageView,url,options);
    }
}
