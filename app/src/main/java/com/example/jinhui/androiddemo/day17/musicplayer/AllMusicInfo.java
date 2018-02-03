package com.example.jinhui.androiddemo.day17.musicplayer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class AllMusicInfo {

    static ArrayList<MusicInfo> musicList = new ArrayList<MusicInfo>();
    Context context;

    public AllMusicInfo(Context context) {
        this.context = context;
    }

    public void queryMediaStore() {
        Log.e("Test", "queryMediaStore");
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        ContentResolver resolver = context.getContentResolver();

        String selection = MediaStore.Audio.Media.IS_MUSIC + "=1 and "
                + MediaStore.Audio.Media.DURATION + ">20000";

        Cursor cursor = resolver.query(uri, new String[] {
                        MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.DURATION }, selection, null,
                MediaStore.Audio.Media.TITLE);

        assert cursor != null;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));

            Log.e("Test", title);
            Log.e("Test", path);
            Log.e("Test", "duration = " + duration);

            MusicInfo music = new MusicInfo(title, path, duration);
            musicList.add(music);

        }

    }
}
