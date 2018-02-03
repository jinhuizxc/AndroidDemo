package com.example.jinhui.androiddemo.day17.musicplayer;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class MusicInfo {

    private String name;
    private String path;
    private long duration;

    public MusicInfo(String name, String path, long duration) {
        super();
        this.name = name;
        this.path = path;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
