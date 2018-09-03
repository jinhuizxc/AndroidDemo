package com.example.jinhui.androiddemo.glide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.jinhui.androiddemo.R;

/**
 * Created by jh on 2018/9/3.
 * Email: 1004260403@qq.com
 * <p>
 * Glide加载圆角图片
 */
public class GlideActivity extends AppCompatActivity {

//    //控件地址https://github.com/hdodenhof/CircleImageView
//    CircleImageView circleImageView;
//    ImageView imageView;
//    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535997696521&di=1ad8d0c8a8055e378d16107af758de8d&imgtype=0&src=http%3A%2F%2Fimg06.tooopen.com%2Fimages%2F20161121%2Ftooopen_sy_187362418112.jpg";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        imageView = (ImageView) findViewById(R.id.image);
//        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
//
//        Glide.with(this)
//                .load(url)
//                .into(imageView);
//        //方案一：不用动画（ .dontAnimate()）
////        Glide.with(this)
////                .load(url)
////                .error(R.drawable.error)
////                .placeholder(R.drawable.default_dog)
////                .dontAnimate()
////                .into(circleImageView);
//
//        //方案二 :不适用占位符
////        Glide.with(this).load(url)
////                .error(R.drawable.error)
////                .centerCrop()
////                .into(circleImageView);
//        //方案三 ：控件是ImageView或者CircleImageView
//        Glide.with(this).load(url)
//                .asBitmap().centerCrop().error(R.drawable.error)
//                .placeholder(R.drawable.ic_launcher)
//                .into(new BitmapImageViewTarget(imageView) {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(imageView.getResources(), resource);
//                        circularBitmapDrawable.setCircular(true);
//                        imageView.setImageDrawable(circularBitmapDrawable);
//                    }
//                });
//        //方案四 :控件是CircleImageView
//        Glide.with(this).load(url).asBitmap().centerCrop().error(R.drawable.error).placeholder(R.drawable.default_dog)
//                .into(new BitmapImageViewTarget(circleImageView) {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        circleImageView.setImageBitmap(resource);
//                    }
//                });
//        //方案五： 重写BitmapTransformation，控件是ImageView ，参考https://github.com/wasabeef/glide-transformations
//        Glide.with(this).load(url).error(R.drawable.error)
//                .placeholder(R.drawable.default_dog)
//                .bitmapTransform(new CropCircleTransformation(this)).into(imageView);
//    }
}



