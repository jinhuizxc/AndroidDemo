package com.example.jinhui.androiddemo.day17.soundpool;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class SoundPlay {

    int sound01;
    int sound02;
    int sound03;
    int sound04;

    private SoundPool pool;

    public SoundPlay(Context context) {
        // 音效池对象，指定能载入的音效的数量，指定音效资源的类型
        pool = new SoundPool(4,  AudioManager.STREAM_MUSIC, 0);

        //载入音效资源
        sound01 = pool.load(context, R.raw.sound01, 1);
        sound02 = pool.load(context, R.raw.sound02, 1);
        sound03 = pool.load(context, R.raw.sound03, 1);
        sound04 = pool.load(context, R.raw.sound04, 1);

    }

    public void play(int soundId){
        //播放音效
        pool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void release(){
        pool.stop(sound01);
        pool.stop(sound02);
        pool.stop(sound03);
        pool.stop(sound04);
        pool.release();
    }
}
