package com.example.jinhui.androiddemo.day3.interface1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 */

public class UiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建布局对象
        LinearLayout linearLayout = new LinearLayout(this);
        //设置布局方向
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //利用View类直接创建对应view对象
        Button bt = new Button(this);
        bt.setText("按钮");
        TextView tx = new TextView(this);
        tx.setText("就是一个字");

        //添加view对象，addView 是ViewGroup的方法，因为ViewGroup是所有布局控件的父亲
        linearLayout.addView(tx);
        linearLayout.addView(bt);

        //设置显示的布局
        setContentView(linearLayout);
//        setContentView(R.layout.activity_ui);
    }
}
