package com.example.jinhui.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.day1.WidgetAndLayoutActivity;
import com.example.jinhui.androiddemo.day2.ListenerActivity;
import com.example.jinhui.androiddemo.day3.interface1.InterfaceActivity;

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


    @BindView(R.id.bt_day4)
    Button btDay4;
    @BindView(R.id.bt_day5)
    Button btDay5;
    @BindView(R.id.bt_day6)
    Button btDay6;
    @BindView(R.id.bt_day7)
    Button btDay7;
    @BindView(R.id.bt_day8)
    Button btDay8;
    @BindView(R.id.bt_day9)
    Button btDay9;
    @BindView(R.id.bt_widget)
    Button btWidget;
    @BindView(R.id.bt_listener)
    Button btListener;
    @BindView(R.id.bt_interface)
    Button btInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_widget, R.id.bt_listener, R.id.bt_interface, R.id.bt_day4, R.id.bt_day5, R.id.bt_day6, R.id.bt_day7, R.id.bt_day8, R.id.bt_day9})
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
            case R.id.bt_day4:
                break;
            case R.id.bt_day5:
                break;
            case R.id.bt_day6:
                break;
            case R.id.bt_day7:
                break;
            case R.id.bt_day8:
                break;
            case R.id.bt_day9:
                break;
        }
    }
}
