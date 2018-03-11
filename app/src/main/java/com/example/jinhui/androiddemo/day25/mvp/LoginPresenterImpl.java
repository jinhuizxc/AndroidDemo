package com.example.jinhui.androiddemo.day25.mvp;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class LoginPresenterImpl implements LoginPresenter, LoginModel.OnLoginListener{

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView view, LoginModel model) {
        this.loginView = view;
        this.loginModel = model;
    }

    @Override
    public void doLogin(String username, String password) {
        loginView.showProgress();
        loginModel.login(username, password, this);
    }

    @Override
    public void onLoginSuccess() {
        loginView.hideProgress();
        loginView.loginSuccess();
    }

    @Override
    public void onLoginFail() {
        loginView.hideProgress();
        loginView.loginFailure();
    }
}
