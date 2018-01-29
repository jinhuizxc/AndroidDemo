package com.example.jinhui.androiddemo.day4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 *
 * 1.AndroidManifest.xml设置界面全屏及无标题显示

 1)设置某个Activity界面全屏显示
 在主配置文件AndroidManifest.xml中进行配置
 在相应的Activity中节点中添加属性：
 android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
 即可以设置某个Activity全屏显示。

 代码：
 AndroidManifest.xml：
 ......
 <activity
 android:name=".MainActivity"
 android:label="@string/app_name"
 android:theme="@android:style/Theme.Black.NoTitleBar.Fullscreen" >

 可以看到现在屏幕全屏，状态栏和标题栏都消失了，需要注意的是我们设置全屏后屏幕背景会默认变为黑色，如果需要设置背景可在布局文件中进行更改配置。

 2)设置无标题显示
 若设置成 android:theme="@android:style/Theme.NoTitleBar"
 即是只是设置成无标题状态。
 */

public class FullscreenActivity extends AppCompatActivity {

    /**
     *  android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
     *  设置全屏提示错误：
     *    Caused by: java.lang.IllegalStateException: You need to use a Theme.AppCompat theme (or descendant) with this activity.
     *
     *  设置 android:theme="@style/Theme.AppCompat.Light.NoActionBar"，无标题栏，有状态栏；
     *  设置  android:theme="@style/Theme.AppCompat.DayNight.NoActionBar"与上面效果差不多的；
     *  设置 android:theme="@style/Theme.AppCompat.NoActionBar" 无标题栏，有状态栏,背景为黑色。
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
    }
}
