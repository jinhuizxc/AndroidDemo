package com.example.jinhui.androiddemo.day6.tweenanim;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 *
 * 之前学过的动画基于Activity界面，从这里开始动画可以设置到相应的控件。
 *
 * Alpha透明度动画
 * Scale尺寸缩放动画
 * Translate位置移动动画
 * Rotate旋转动画

 AlphaAnimation透明度动画
 1.fromAlpha动画起始时的透明度 （1.0表示完全不透明）
 2.toAlpha动画终止时的透明度 （0.0表示完全透明）

 ScaleAnimation尺寸缩放动画
 1.fromX，toX分别是起始和结束时x坐标上的伸缩尺寸
 2.fromY，toY分别是起始和结束时y坐标上的伸缩尺寸
 3.pivotX，pivotY分别为伸缩动画相对于x，y轴开始位置

 RotateAnimation旋转动画
 1.fromDegrees
 2.toDegrees
 3.pivotX,pivotY分别为旋转动画相对于x,y的坐标开始位置

 Translate位置移动动画
 fromXDelta,fromYDelta分别是起始的X，Y的坐标
 toXDelta,toYDelta分别是结束时X，Y的坐标

 补间动画的共同属性:
 Duration：动画持续时间（单位：毫秒）
 fillAfter：设置为true，动画转化在动画结束后被应用
 interpolator：动画插入器（加速、减速插入器）
 repeatCount：动画重复次数
 repeatMode：顺序重复/倒序重复
 startOffset：动画之间的时间间隔(应用于组合动画)

 动画监听器AnimationListener:
 //注册动画监听器
 ani.setAnimationListener(new AnimationListener() {
 //当动画开始播放时，调用该方法
 @Override
 public void onAnimationStart(Animation animation) {

 }
 //当动画重复播放时，调用该方法
 @Override
 public void onAnimationRepeat(Animation animation) {

 }
 //当动画播放完毕后，调用该方法
 @Override
 public void onAnimationEnd(Animation animation) {

 }
 });

 动画实现方式——2种方式:
 1.配置文件（/res/anim）——alpha、scale、translate、rotate (更简单)

 2.Java代码实现——AlphaAnimation/ScaleAnimation/TranslateAnimation/RotateAnimation (更灵活)

 用Java代码去创建

 //创建Alpha动画(透明度为10%-100%)
 Animation alpha = new AlphaAnimation(0.1f,1.0f);

 //设置动画时间为5秒
 alpha.setDuration(5000);
 //开始播放
 img.startAnimation(alpha);

 加载配置文件
 Animation scale = AnimationUtils.loadAnimation(context, R.anim.scale_anim);
 //开始动画
 img.startAnimation(scale);

 */

public class TweenAnimationActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweenanim);
        ButterKnife.bind(this);
    }

    public void clickAlpha(View view) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(3000);
        // 让图片播放透明度动画
        imageView.startAnimation(alphaAnimation);
    }

    public void clickTranslation(View view) {
        // 平移
        Animation translateAnimation = new TranslateAnimation(0, 0, 0, 100);
        // 设置加速
        translateAnimation.setInterpolator(this, android.R.anim.accelerate_interpolator);
        translateAnimation.setDuration(3000);
        imageView.startAnimation(translateAnimation);
    }

    public void clickRotation(View view) {
        // 旋转
        Animation rotateAnimation = new RotateAnimation(0, 360, imageView.getWidth()/2, imageView.getHeight()/2);
        rotateAnimation.setDuration(3000);
        imageView.startAnimation(rotateAnimation);
    }

    public void clickScale(View view) {
        //缩放
        Animation scaleAnimation = new ScaleAnimation(1, 0.5f, 1, 0.5f, imageView.getWidth()/2, imageView.getHeight()/2);
        scaleAnimation.setDuration(3000);
        imageView.startAnimation(scaleAnimation);
    }

    public void clickSet(View view) {
        //解析动画文件，生成动画对象
        Animation ani = AnimationUtils.loadAnimation(this, R.anim.set);

        imageView.startAnimation(ani);

        //注册动画监听器
        ani.setAnimationListener(new Animation.AnimationListener() {

            //当动画开始播放时，调用该方法
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("Test", "onAnimationStart");
            }

            //当动画重复播放时，调用该方法
            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("Test", "onAnimationRepeat");
            }

            //当动画播放完毕后，调用该方法
            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("Test", "onAnimationEnd");

                Intent intent = new Intent();

                intent.setClass(TweenAnimationActivity.this, TweenAnimationNextActivity.class);

                startActivity(intent);

            }
        });
    }
}
