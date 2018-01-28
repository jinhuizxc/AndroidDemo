package com.example.jinhui.androiddemo.day3.intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 *
 * Activity跳转时界面切换动画
 * Android中原生的界面跳转看起来会很生硬，可以自定义切换动画来更改界面跳转的效果，让用户有一种耳目一新的感觉。使用这种切换动画可以设置Activity的移动、旋转、缩放以及透明度的变化效果。

 这里会用到overridePendingTransition(int enterAnim, int exitAnim)这个方法，该方法用于设置Activity界面切换时的动画。enterAnim表示另一个Activity进入时的动画，exitAnim表示当前Activity退出时的动画，需要创建两个xml文件来设定进入和退出的动画效果。

 在res目录下创建一个anim的文件夹，该文件夹下存放用于进行切换动画的
 xml文件，scale_enter.xml和exit.xml。

 1、AlphaAnimation动画

 alpha动画类型的常用动画参数：

 1. android:fromAlpha：起始透明度
 2. android:toAlpha：结束透明度
 1.0表示完全不透明
 0.0表示完全透明

 3. android:duration：播放时间

 4. android:interpolator：速度变化，常用三个属性
 accelerate_interpolator 使动画在开始的时候最慢,然后逐渐加速；
 decelerate_interpolator 使动画在开始的时候最快,然后逐渐减速；
 accelerate_decelerate_interpolator以中间位置为分界点，使动画在开始的时候最慢,然后逐渐加速，然后逐渐减速结束的位置最慢。
 */

public class Jump3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump3);
    }
}
