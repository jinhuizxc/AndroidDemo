package com.example.jinhui.androiddemo.day1_layout.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * 帧布局
 * 是最简单的布局了。所有放在布局里的控件，都按照层次堆叠在屏幕的左上角。后加进来的控件覆盖前面的控件。
 注意几点：
 帧布局嵌套在别的布局里时，帧布局的大小由子控件中最大的子控件决定。
 前景图像：永远处于帧布局最顶的,直接面对用户的图像,,就是不会被覆盖的图片
 */

public class FramelayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout);
    }
}
