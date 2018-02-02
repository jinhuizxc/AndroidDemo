package com.example.jinhui.androiddemo.day12;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 * 所有的控件都是直接或者间接继承自View，
 * 所有的布局，都是直接或间接继承自ViewGroup。
 *
 * View是Android最基本的UI，可以在屏幕上绘制一块矩形区域。
 * ViewGroup是一种特殊的View，它可以包含很多个子View或者子ViewGroup，是一个用于放控件和布局的容器。

 通过组合方式创建自定义控件：
 继承LinearLayout线性布局
 使用LayoutInflater解析自定义布局文件，添加监听事件

 */

public class MyLinearLayout extends LinearLayout {

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

//        View view = LayoutInflater.from(context).inflate(R.layout.down, this);
//        Button btn01 = (Button)view.findViewById(R.id.button1);
//        Button btn02 = (Button)view.findViewById(R.id.button2);
        LayoutInflater.from(context).inflate(R.layout.down, this);

        Button btn01 = (Button) findViewById(R.id.button1);
        Button btn02 = (Button) findViewById(R.id.button2);

        btn01.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "收藏", Toast.LENGTH_SHORT).show();
            }
        });

        btn02.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "购物车", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
