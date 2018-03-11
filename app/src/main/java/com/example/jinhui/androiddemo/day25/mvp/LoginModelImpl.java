package com.example.jinhui.androiddemo.day25.mvp;

import android.os.Handler;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.equals("1") && password.equals("1")) {
                    listener.onLoginSuccess();
                } else {
                    listener.onLoginFail();
                }
            }
        }, 3000);
    }
}
