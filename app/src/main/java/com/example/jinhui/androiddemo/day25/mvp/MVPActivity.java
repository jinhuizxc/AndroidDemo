package com.example.jinhui.androiddemo.day25.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class MVPActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.pb_wait_login)
    ProgressBar pbWaitLogin;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        ButterKnife.bind(this);

        // 初始化
        loginPresenter = new LoginPresenterImpl(this, new LoginModelImpl());
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        // 简单进行非空验证
        if (!username.equals("") && !password.equals("")) {
            //这里想要执行登录操作，需要通过Present控制Model请求
            loginPresenter.doLogin(username, password);
        } else {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showProgress() {
        pbWaitLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbWaitLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        //登录成功，跳转到主页面
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        //登录失败，停留在登录页面
    }

}
