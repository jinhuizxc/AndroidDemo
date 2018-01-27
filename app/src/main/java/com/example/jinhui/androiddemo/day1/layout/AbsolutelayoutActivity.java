package com.example.jinhui.androiddemo.day1.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * 绝对布局,目前已经被弃用！
 *
 * 绝对布局也叫坐标布局，指定元素的绝对位置，因为适应差很差，一般很少用到。
 * 可以使用RelativeLayout替代
 * 常用属性
 * android:layout_x  组件x坐标
 * android:layout_y  组件y坐标
 *
 */

public class AbsolutelayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolutelayout);
    }
}
