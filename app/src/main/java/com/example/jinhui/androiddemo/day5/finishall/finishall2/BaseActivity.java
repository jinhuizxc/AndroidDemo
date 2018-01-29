package com.example.jinhui.androiddemo.day5.finishall.finishall2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.day5.finishall.Tool;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 *
 * 1.定义Tool类
 public class Tool{
 //静态链表
 public static List<Activity> list = new ArrayList<Activity>();
 }
 2.创建BaseActivity继承Activity
 //添加当前类对象到链表，注意理解类的继承
 Tool.list.add(this);
 2.分别让MainActivity、SecondActivity、ThirdActivity继承BaseActivity，
 跳转设置MainActivity->SecondActivity->ThirdActivity,在ThirdActivity里面
 添加语句
 for (int i = 0; i < Tool.list.size(); i++) {
 Tool.list.get(i).finish();
 }

 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加当前类对象到链表，注意理解类的继承, 别的Activity继承BaseActivity。
        Tool.list.add(this);
    }
}
