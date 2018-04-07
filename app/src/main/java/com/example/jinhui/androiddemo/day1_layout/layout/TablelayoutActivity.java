package com.example.jinhui.androiddemo.day1_layout.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * 表格布局
 *
 * 表格布局模型以行列的形式管理子控件，每一行为一个TableRow的对象，TableRow可以添加子控件，每添加一个为一列，当然也可以是一个View的对象。
 android:stretchColumns:设置指定的列为可伸展的列，以填满剩下的多余空白空间，若有多列需要设置为可伸展，请用逗号将需要伸展的列序号隔开。
 android:shrinkColumns:设置指定的列为可收缩的列。当可收缩的列太宽(内容过多)不会被挤出屏幕。当需要设置多列为可收缩时，将列序号用逗号隔开。
 同一个tablelayout中的列数受TableRow中的列数受最大的影响
 */

public class TablelayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablelayout);
    }
}
