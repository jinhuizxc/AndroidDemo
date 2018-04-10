package com.example.jinhui.androiddemo.day3_interface.dynamic_loading;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/4/11.
 * Email:1004260403@qq.com
 *
 * checkbox + textview 动态加载布局显示，要求textview内容多的时候可以换行！
 */
public class Example1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_example1);

        // 动态加载布局
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);



        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        RadioButton radioButton = new RadioButton(this);
        TextView textView = new TextView(this);
        linearLayout1.addView(radioButton);
        linearLayout1.addView(textView);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(0,0);
        lp2.width = LinearLayout.LayoutParams.MATCH_PARENT;
        lp2.height = LinearLayout.LayoutParams.WRAP_CONTENT;

        linearLayout1.setLayoutParams(lp2);

        linearLayout.addView(linearLayout1);
        setContentView(linearLayout);
    }
}
