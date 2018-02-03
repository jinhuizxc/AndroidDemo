package com.example.jinhui.androiddemo.day17.musicplayer;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day17.soundpool.SoundPlay;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 * <p>
 * 音乐播放类
 * <p>
 * 概念：
 * MediaPlayer可用于控制播放声音影像
 * 在开始播放之前，MediaPlayer对象必须要进入Prepared状态。
 * <p>
 * 一旦发生错误，MediaPlayer对象会进入到Error状态。
 * 为了重用一个处于Error状态的MediaPlayer对象，
 * 可以调用reset()方法来把这个对象恢复成Idle状态。
 * <p>
 * <p>
 * 播放音乐前准备
 * mediaPlayer.prepare();
 * 播放音乐
 * mediaPlayer.start();
 * <p>
 * 暂停音乐
 * mediaPlayer.pause();
 * <p>
 * 停止音乐
 * mediaPlayer.stop();
 * <p>
 * 释放音乐资源
 * mediaPlayer.release();
 * <p>
 * 检测当前音乐是否处于播放状态
 * mediaPlayer.isPlaying();
 * <p>
 * 设置当前音乐循环播放
 * mediaPlayer.setLooping(true);
 * <p>
 * 获取当前音乐的总时长
 * mediaPlayer.getDuration();
 * <p>
 * 得到当前音乐的播放位置
 * mediaPlayer.getCurrentPosition();
 * <p>
 * 监听当前音乐是否播放完毕
 * OnCompletionListener
 * <p>
 * 设置音乐的播放位置
 * seekTo(position)
 */

public class PlayActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.bt_play)
    Button btPlay;
    @BindView(R.id.bt_pause)
    Button btPause;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.seekBar1)
    SeekBar seekBar1;
    @BindView(R.id.bt_next)
    Button btNext;
    @BindView(R.id.bt_pre)
    Button btPre;

    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    SeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        textView2.setText(sdf.format(AllMusicInfo.musicList.get(0).getDuration()));
        registerReceiver(receiver, new IntentFilter("update music time"));

        // 查多媒体数据库中的音乐文件的名字，路径，时长
        new AllMusicInfo(this).queryMediaStore();
        // 添加监听
        seekBar.setOnSeekBarChangeListener(this);
    }

    @OnClick({R.id.bt_play, R.id.bt_pause, R.id.bt_next, R.id.bt_pre})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.bt_play:
                intent = new Intent(this, MusicService.class);
                intent.putExtra("control", "start");
                startService(intent);
                break;
            case R.id.bt_pause:
                intent = new Intent(this, MusicService.class);
                intent.putExtra("control", "pause");
                startService(intent);
                break;
            case R.id.bt_next:
                intent = new Intent(this, MusicService.class);
                intent.putExtra("control", "next");
                startService(intent);
                break;
            case R.id.bt_pre:
                intent = new Intent(this, MusicService.class);
                intent.putExtra("control", "pre");
                startService(intent);
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textView1.setText(sdf.format(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // 暂停音乐
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("control", "pause");
        startService(intent);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // 更新的音乐进度
        int progress = seekBar.getProgress();
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("control", "update");
        intent.putExtra("progress", progress);
        startService(intent);
    }

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int current = intent.getIntExtra("current", -1);
            int duration = intent.getIntExtra("duration", -1);
            textView1.setText(sdf.format(current));
            textView2.setText(sdf.format(duration));
            // 更新音乐进度条
            seekBar.setMax(duration);
            seekBar.setProgress(current);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.addSubMenu("退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 关闭Activity
        finish();
        // 关闭Service
        stopService(new Intent(this, MusicService.class));
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 撤销广播
        unregisterReceiver(receiver);
    }
}
