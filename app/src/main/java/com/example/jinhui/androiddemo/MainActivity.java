package com.example.jinhui.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.day1.WidgetAndLayoutActivity;
import com.example.jinhui.androiddemo.day2.ListenerActivity;
import com.example.jinhui.androiddemo.day3.interface1.InterfaceActivity;
import com.example.jinhui.androiddemo.day4.Interface2Activity;
import com.example.jinhui.androiddemo.day5.ActivityActivity;
import com.example.jinhui.androiddemo.day6.AnimActivity;
import com.example.jinhui.androiddemo.day7.ThreadActivity;
import com.example.jinhui.androiddemo.day8.HttpActivity;
import com.example.jinhui.androiddemo.day9.AdvanceInterface1Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 2018/1/23,
 * 最近在学习自定义篇，启舰大神的文章，
 * 想着以前自己也有很多Android笔记，这么久了，
 * 可以整理一篇合集，做到温故而知新！
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bt_widget)
    Button btWidget;
    @BindView(R.id.bt_listener)
    Button btListener;
    @BindView(R.id.bt_interface)
    Button btInterface;
    @BindView(R.id.bt_interface2)
    Button btInterface2;
    @BindView(R.id.bt_activity)
    Button btActivity;
    @BindView(R.id.bt_anim)
    Button btAnim;
    @BindView(R.id.bt_thread)
    Button btThread;
    @BindView(R.id.bt_http)
    Button btHttp;
    @BindView(R.id.bt_advanceInterface1)
    Button btAdvanceInterface1;
    @BindView(R.id.bt_advanceInterface2)
    Button btAdvanceInterface2;
    @BindView(R.id.bt_advanceInterface3)
    Button btAdvanceInterface3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_widget, R.id.bt_listener, R.id.bt_interface,
            R.id.bt_interface2, R.id.bt_activity, R.id.bt_anim,
            R.id.bt_thread, R.id.bt_http, R.id.bt_advanceInterface1,
            R.id.bt_advanceInterface2, R.id.bt_advanceInterface3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_widget:
                startActivity(new Intent(this, WidgetAndLayoutActivity.class));
                break;
            case R.id.bt_listener:
                startActivity(new Intent(this, ListenerActivity.class));
                break;
            case R.id.bt_interface:
                startActivity(new Intent(this, InterfaceActivity.class));
                break;
            case R.id.bt_interface2:
                startActivity(new Intent(this, Interface2Activity.class));
                break;
            case R.id.bt_activity:
                startActivity(new Intent(this, ActivityActivity.class));
                break;
            case R.id.bt_anim:
                startActivity(new Intent(this, AnimActivity.class));
                break;
            case R.id.bt_thread:
                startActivity(new Intent(this, ThreadActivity.class));
                break;
            case R.id.bt_http:
                startActivity(new Intent(this, HttpActivity.class));
                break;
            case R.id.bt_advanceInterface1:
                startActivity(new Intent(this, AdvanceInterface1Activity.class));
                break;
            case R.id.bt_advanceInterface2:
                break;
            case R.id.bt_advanceInterface3:
                break;
        }
    }


}
