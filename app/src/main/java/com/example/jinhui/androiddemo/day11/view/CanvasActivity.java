package com.example.jinhui.androiddemo.day11.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day11.view.MyView;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 *
 * 创建自定义控件步骤：

 1.继承View，重写onDraw(Canvas)方法，绘制自定义控件。
 在layout_main布局文件中
 添加自定义view标签。

 <!-- 自定义标签 -->
 <com.example.view.MyView
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 android:layout_below="@+id/tv"
 />
 重写onDraw(Canvas)方法

 得到自定义控件的宽和高(长度以像素px为单位)：
 this.getWidth()
 this.getHeight()

 没有在布局加入标签，那怎么找到相应布局呢？
 通过setContentView(new MyView(this))这个方法！这样就不必在布局xml文件里添加标签了。
 */

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
//        setContentView(new MyView(this));
    }
}
