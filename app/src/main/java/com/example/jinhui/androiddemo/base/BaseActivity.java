package com.example.jinhui.androiddemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by jh on 2018/9/9.
 * Email: 1004260403@qq.com
 *
 * 基类activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
       initView(savedInstanceState);
       initData();
    }

    protected abstract void initData();

    public abstract void initView(Bundle savedInstanceState);

    public abstract int getLayoutId();
    
}
