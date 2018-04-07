package com.example.jinhui.androiddemo.day1_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * PrograssBar常用属性，可用于显示程序执行进度，避免长时间执行某个耗时操作时，
 * 让用户感觉程序失去响应，从而提高用户界面的友好性
 *
 *
 * Android提供2种形式：
 * 1.水平类型进度条
 * 2.圆形进度条
 有如下几种常用属性值：

 1、style设置进度条的风格，Android支持几种风格的进度条，通过style属性来为ProgressBar来指定风格。

 style="?android:attr/progressBarStyleHorizontal"：水平进度条
 style="?android:attr/progressBarStyleSmall"：小环形进度条
 style="?android:attr/progressBarStyleLarge"：大环形进度条

 2、android:max设置该进度条的最大值，在代码中可以调用getMax方法获得进度条的最大值

 3、android:progress设置该迚度条的已完成进度值，在代码中调用setProgress方法来动态设置迚度值；

 4、android:secondaryProgress设置该进度条上已完成的第二进度值，该属性主要是为缓存需要所涉及的，比如在看网络视频时候都会有一个缓存的进度条以及还要一个播放的进度，在这里缓存的进度就可以是secondaryProgress；

 5、android:indeterminate该属性如果设置为true则设置进度条不精确显示进度，ProgressBar分为确定的和不确定的，上面说的播放进度、缓存等就是确定的。相反地，不确定的就是不清楚、不确定一个操作需要多长时间来完成，这个时候就需要用的不确定的ProgressBar了；

 6、android:progressDrawable设置该进度条的轨道对应的Drawable对象，后期自定义进度条时用到。
 */

/**
 *  android：visibility
 *  所有Android 控件都具 有这个属性，可以通过 android:visibility进行指定。
 *  可选值有三种进行指定，可选值有三种visible、invisible和 gone。
 *
 *  visible 表示控件是可见的，这个值是默认值，不指定android:visibility时，所有空间都是可见的。
 *  invisible表示空间不可见，但是仍然占据着原来的位置和大小->理解为透明状态。
 *  gone表示空间不仅不可见，而且不再占用屏幕空间。
 *  通过代码设置控件的可见性
 *  setVisibility（）方法参数为：
 *  View.VISIBLE、View.INVISIBLE和View.GONE三种值。
 */
public class PrograssbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prograssbar);
    }
}
