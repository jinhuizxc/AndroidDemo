package com.example.jinhui.androiddemo.day17.soundpool;

import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 * <p>
 * 音效池soundpool
 *
 概念
 SoundPool类是 android.media 包里提供的一个用来播放声音文件的类,
 可以支持同时播放多个声音文件，可以控制每个文件的循环次数。

 SoundPool类
 支持载入多个音效资源，播放时间在10s内的音乐可以作为音效。
 //创建音效池对象。规定音效池最多容纳5个音效
 SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
 //载入音效资源
 int soundId01 = soundPool.load(this, R.raw.mouse1, 0);
 //播放音效
 soundPool.play(soundId01, 0.5f, 0.5f, 0, 0, 1.0f);

 注意:
 音频文件不能太大，否则会造成AudioCache的Heap size overflow。
 要在程序的onDestroy里调用 soundPool.release(),否则的话会第二次打开这个程序，不出声音。
 */

public class SoundPoolActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    SoundPlay sound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundpool);
        ButterKnife.bind(this);

        sound = new SoundPlay(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                sound.play(sound.sound01);
                break;
            case R.id.button2:
                sound.play(sound.sound02);
                break;
            case R.id.button3:
                sound.play(sound.sound03);
                break;
            case R.id.button4:
                sound.play(sound.sound04);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sound.release();
    }
}
