package com.example.jinhui.androiddemo.day10;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day10.welcome.UserActivity;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 * <p>
 * 作为欢迎页
 */

public class WelcomeActivity extends AppCompatActivity {

    // 1. Handler方式
//    Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        //向消息队列发送消息，要求UI现在在5秒以后处理事情(执行run中的代码)
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(WelcomeActivity.this, UserActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);

        // 2.线程Thread方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 延时3秒后执行跳转
                Intent intent = new Intent(WelcomeActivity.this, UserActivity.class);
                startActivity(intent);
            }
        }).start();

    }
}
