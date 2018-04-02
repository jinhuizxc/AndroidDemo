package com.example.jinhui.androiddemo.day8_http_tcp_udp.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class TimerTaskActivity extends AppCompatActivity implements InterUpdate {

    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    MyTask task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timertask);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                int totalTime = Integer.parseInt(editText1.getText().toString());
                task = new MyTask(this);
                // 启动异步任务, 开始倒计时
                task.execute(totalTime, 50, 70);
                break;
            case R.id.button2:
                // 取消异步任务
                task.cancel(true);
                break;
        }
    }

    // 回调方法，开始执行异步任务的时候，系统自动调用该方法
    @Override
    public void update() {
        Toast.makeText(this, "任务开始", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateCount(int count) {
        editText1.setText(String.valueOf(count));
    }

    @Override
    public void updateOver(String result) {
        Toast.makeText(this,  result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cancle(String s) {
        Toast.makeText(this,  s, Toast.LENGTH_SHORT).show();
    }
}
