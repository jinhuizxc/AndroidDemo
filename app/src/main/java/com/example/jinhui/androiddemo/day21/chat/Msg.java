package com.example.jinhui.androiddemo.day21.chat;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class Msg {

    private String message;
    private boolean isLeft;

    public Msg(String message, boolean isLeft) {
        this.message = message;
        this.isLeft = isLeft;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }
}
