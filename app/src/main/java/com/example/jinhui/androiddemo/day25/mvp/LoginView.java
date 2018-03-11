package com.example.jinhui.androiddemo.day25.mvp;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public interface LoginView {

    void showProgress();
    void hideProgress();
    void loginSuccess();
    void loginFailure();

}
