package com.example.jinhui.androiddemo.day1_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * Button常用属性
 *
 * Button继承了TextView,所以TextView的属性和方法同样适用于Button。
 *
 * android:onClick:表示为按钮设置了监听器（后续章节介绍），
 * 若按钮被按下，会执行其属性对应的方法，如：
 * xml文件中：android:onClick=“myClick”，
 * 那么在Java代码中就应该有一个方法名称为public void myClick(View v){ }的方法被执行；
 *
 * android:enabled:设置按钮是否能被点击，true表示可被点击，false表示不可被点击，不加这条属性按钮默认可点击。
 *
 */

public class ButtonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    }
}
