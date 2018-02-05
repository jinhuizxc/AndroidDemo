package com.example.jinhui.androiddemo.day22.gridview.example;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class ItemData {

    private String name;

    // 文字内容是否显示为白色
    private boolean isWhite;

    public ItemData(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }
}
