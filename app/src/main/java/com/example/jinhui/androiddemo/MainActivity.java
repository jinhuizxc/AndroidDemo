package com.example.jinhui.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.day1.WidgetAndLayoutActivity;
import com.example.jinhui.androiddemo.day10.AdvanceInterface2Activity;
import com.example.jinhui.androiddemo.day11.AdvanceInterface3Activity;
import com.example.jinhui.androiddemo.day12.AdvanceInterface4Activity;
import com.example.jinhui.androiddemo.day13.AdvanceInterface5Activity;
import com.example.jinhui.androiddemo.day14.Service1Activity;
import com.example.jinhui.androiddemo.day15.Service2Activity;
import com.example.jinhui.androiddemo.day16.BroadcastReceiverActivity;
import com.example.jinhui.androiddemo.day17.MusicplayerActivity;
import com.example.jinhui.androiddemo.day2.ListenerActivity;
import com.example.jinhui.androiddemo.day20.UiOptimize1Activity;
import com.example.jinhui.androiddemo.day21.UiOptimize2Activity;
import com.example.jinhui.androiddemo.day22.UiOptimize3Activity;
import com.example.jinhui.androiddemo.day23.UiOptimize4Activity;
import com.example.jinhui.androiddemo.day24.UiOptimize5Activity;
import com.example.jinhui.androiddemo.day25.ModelActivity;
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
    @BindView(R.id.bt_advanceInterface4)
    Button btAdvanceInterface4;
    @BindView(R.id.bt_advanceInterface5)
    Button btAdvanceInterface5;
    @BindView(R.id.bt_service01)
    Button btService01;
    @BindView(R.id.bt_service02)
    Button btService02;
    @BindView(R.id.bt_broadcastreceiver)
    Button btBroadcastreceiver;
    @BindView(R.id.bt_musicplayer)
    Button btMusicplayer;
    @BindView(R.id.bt_datastore)
    Button btDatastore;
    @BindView(R.id.bt_contentprovider)
    Button btContentprovider;
    @BindView(R.id.bt_uioptimize01)
    Button btUioptimize01;
    @BindView(R.id.bt_uioptimize02)
    Button btUioptimize02;
    @BindView(R.id.bt_uioptimize03)
    Button btUioptimize03;
    @BindView(R.id.bt_uioptimize04)
    Button btUioptimize04;
    @BindView(R.id.bt_uioptimize05)
    Button btUioptimize05;
    @BindView(R.id.bt_model)
    Button btModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_widget, R.id.bt_listener, R.id.bt_interface,
            R.id.bt_interface2, R.id.bt_activity, R.id.bt_anim,
            R.id.bt_thread, R.id.bt_http, R.id.bt_advanceInterface1,
            R.id.bt_advanceInterface2, R.id.bt_advanceInterface3,
            R.id.bt_advanceInterface4, R.id.bt_advanceInterface5,
            R.id.bt_service01, R.id.bt_service02, R.id.bt_broadcastreceiver,
            R.id.bt_musicplayer, R.id.bt_datastore, R.id.bt_contentprovider,
            R.id.bt_uioptimize01, R.id.bt_uioptimize02, R.id.bt_uioptimize03,
            R.id.bt_uioptimize04, R.id.bt_uioptimize05, R.id.bt_model})
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
                startActivity(new Intent(this, AdvanceInterface2Activity.class));
                break;
            case R.id.bt_advanceInterface3:
                startActivity(new Intent(this, AdvanceInterface3Activity.class));
                break;
            case R.id.bt_advanceInterface4:
                startActivity(new Intent(this, AdvanceInterface4Activity.class));
                break;
            case R.id.bt_advanceInterface5:
                startActivity(new Intent(this, AdvanceInterface5Activity.class));
                break;
            case R.id.bt_service01:
                startActivity(new Intent(this, Service1Activity.class));
                break;
            case R.id.bt_service02:
                startActivity(new Intent(this, Service2Activity.class));
                break;
            case R.id.bt_broadcastreceiver:
                startActivity(new Intent(this, BroadcastReceiverActivity.class));
                break;
            case R.id.bt_musicplayer:
                startActivity(new Intent(this, MusicplayerActivity.class));
                break;
            case R.id.bt_datastore:
                break;
            case R.id.bt_contentprovider:
                break;
            case R.id.bt_uioptimize01:
                startActivity(new Intent(this, UiOptimize1Activity.class));
                break;
            case R.id.bt_uioptimize02:
                startActivity(new Intent(this, UiOptimize2Activity.class));
                break;
            case R.id.bt_uioptimize03:
                startActivity(new Intent(this, UiOptimize3Activity.class));
                break;
            case R.id.bt_uioptimize04:
                startActivity(new Intent(this, UiOptimize4Activity.class));
                break;
            case R.id.bt_uioptimize05:
                startActivity(new Intent(this, UiOptimize5Activity.class));
                break;
            case R.id.bt_model:
                startActivity(new Intent(this, ModelActivity.class));
                break;
        }
    }


}
