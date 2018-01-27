package com.example.jinhui.androiddemo.day2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * 监听事件、资源文件
 */

public class ListenerActivity extends AppCompatActivity {

    @BindView(R.id.bt_listener)
    Button btListener;
    @BindView(R.id.bt_res)
    Button btRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_listener, R.id.bt_res})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_listener:
                startActivity(new Intent(this, ViewListenerActivity.class));
                break;
            case R.id.bt_res:
                startActivity(new Intent(this, ResActivity.class));
                break;
        }
    }
}
