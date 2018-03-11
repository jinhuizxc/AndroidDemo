package com.example.jinhui.androiddemo.day8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day8.http.HttpClientActivity;
import com.example.jinhui.androiddemo.day8.task.TimerTaskActivity;
import com.example.jinhui.androiddemo.day8.task.TwoTaskActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 */

public class HttpActivity extends AppCompatActivity {

    @BindView(R.id.bt_timertask)
    Button btTimertask;
    @BindView(R.id.bt_twotask)
    Button btTwotask;
    @BindView(R.id.bt_http)
    Button btHttp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_timertask, R.id.bt_twotask, R.id.bt_http})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_timertask:
                startActivity(new Intent(this, TimerTaskActivity.class));
                break;
            case R.id.bt_twotask:
                startActivity(new Intent(this, TwoTaskActivity.class));
                break;
            case R.id.bt_http:
                startActivity(new Intent(this, HttpClientActivity.class));
                break;
        }
    }
}
