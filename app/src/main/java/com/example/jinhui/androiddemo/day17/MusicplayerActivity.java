package com.example.jinhui.androiddemo.day17;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day17.musicplayer.PlayActivity;
import com.example.jinhui.androiddemo.day17.soundpool.SoundPoolActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 * <p>
 * 音乐文件的载入2种方式:
 * <p>
 * 1.res/raw文件夹下音乐资源
 * 创建MediaPlayer对象
 * 载入res下raw下的音乐文件
 * MediaPlayer.create(R.raw.a_15);
 * <p>
 * 2.载入sdcard下的音乐文件 ：
 * MediaPlayer mediaPlayer = new MediaPlayer()
 * mediaPlayer.setDataSource("/sdcard/m_01.mp3");
 * mediaPlayer.prepare();
 */

public class MusicplayerActivity extends AppCompatActivity {

    @BindView(R.id.bt_musicplayer)
    Button btMusicplayer;
    @BindView(R.id.bt_soundpool)
    Button btSoundpool;
    @BindView(R.id.bt_way1)
    Button btWay1;
    @BindView(R.id.bt_way2)
    Button btWay2;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_way1, R.id.bt_way2, R.id.bt_musicplayer, R.id.bt_soundpool})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_way1:
                doWay1();
                break;
            case R.id.bt_way2:
                doWay2();
                break;
            case R.id.bt_musicplayer:
                Toast.makeText(this, "有bug，待处理", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(this, PlayActivity.class));
                break;
            case R.id.bt_soundpool:
                startActivity(new Intent(this, SoundPoolActivity.class));
                break;
        }
    }

    /**
     * 2.载入sdcard下的音乐文件 ：
     MediaPlayer mediaPlayer = new MediaPlayer()
     mediaPlayer.setDataSource("/sdcard/m_01.mp3");
     mediaPlayer.prepare();
     */
    private void doWay2() {
        Toast.makeText(this, "待处理", Toast.LENGTH_SHORT).show();
    }

    /**
     * 创建MediaPlayer对象
     * 载入res下raw下的音乐文件
     * MediaPlayer.create(R.raw.a_15);
     */
    private void doWay1() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sound01);
        try {
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
