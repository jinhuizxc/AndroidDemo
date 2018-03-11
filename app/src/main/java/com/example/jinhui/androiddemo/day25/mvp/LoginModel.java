package com.example.jinhui.androiddemo.day25.mvp;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public interface LoginModel {

    interface OnLoginListener{
        void onLoginSuccess();

        void onLoginFail();
    }

    void login(String username, String password, OnLoginListener listener);
}
