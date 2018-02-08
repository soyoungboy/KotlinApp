package com.soyoungboy.kotlinapp.util.glide;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/**
 * Created by dell on 2017/7/19.
 *
 * 图片加载自定义
 *
 */

public class ImageloaderOptions {

    private int placeHolder = -1;
    private ImageSize imageSize = null;
    private int errorDrawable = -1;
    private boolean isCrossFade = false;
    private boolean isSkipMemoryCache = false;
    private ViewPropertyTransition.Animator animator = null;
    private BitmapTransformation transformation = null;
    public ImageloaderOptions(){

    }
    public ImageloaderOptions(int placeHolder, ImageSize imageSize, int errorDrawable, boolean isCrossFade,
                              boolean isSkipMemoryCache, ViewPropertyTransition.Animator animator) {
        this.placeHolder = placeHolder;
        this.imageSize = imageSize;
        this.errorDrawable = errorDrawable;
        this.isCrossFade = isCrossFade;
        this.isSkipMemoryCache = isSkipMemoryCache;
        this.animator = animator;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public void setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
    }

    public int getErrorDrawable() {
        return errorDrawable;
    }

    public void setErrorDrawable(int errorDrawable) {
        this.errorDrawable = errorDrawable;
    }

    public boolean isCrossFade() {
        return isCrossFade;
    }

    public void setCrossFade(boolean crossFade) {
        isCrossFade = crossFade;
    }

    public boolean isSkipMemoryCache() {
        return isSkipMemoryCache;
    }

    public void setSkipMemoryCache(boolean skipMemoryCache) {
        isSkipMemoryCache = skipMemoryCache;
    }

    public ViewPropertyTransition.Animator getAnimator() {
        return animator;
    }

    public void setAnimator(ViewPropertyTransition.Animator animator) {
        this.animator = animator;
    }

    public BitmapTransformation getTransformation() {
        return transformation;
    }

    public void setTransformation(BitmapTransformation transformation) {
        this.transformation = transformation;
    }

    class ImageSize{
        int width = 0;
        int height = 0;
        ImageSize(int w, int h){
            this.width = w;
            this.height = h;
        }
    }
}
