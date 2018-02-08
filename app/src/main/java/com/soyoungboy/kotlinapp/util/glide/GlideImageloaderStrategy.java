package com.soyoungboy.kotlinapp.util.glide;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/**
 * Created by dell on 2017/7/19.
 */

public class GlideImageloaderStrategy implements ImageloaderStrategy {

    @Override
    public void showImage(View v, String url, RequestOptions options) {
        if (v instanceof ImageView){
            ImageView image = (ImageView) v;
            GlideRequest request = GlideApp.with(image.getContext()).load(url);
            loadOptions(request,options).listener(new RequestListener() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {

//                    Logger.d("dataSource:" + dataSource.name());
                    return false;
                }
            }).into(image);
        }
    }

    @Override
    public void showImage(View v, int id, RequestOptions options) {
        if (v instanceof ImageView){
            ImageView image = (ImageView) v;
            GlideRequest request = GlideApp.with(image.getContext()).load(id);
            loadOptions(request,options).into(image);
        }
    }

    private GlideRequest loadOptions(GlideRequest dtr ,RequestOptions options){
        if (options == null){
            return dtr;
        }
        dtr.apply(options);
        return dtr;
    }
}
