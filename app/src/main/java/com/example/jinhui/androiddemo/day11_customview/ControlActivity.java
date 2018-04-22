package com.example.jinhui.androiddemo.day11_customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day11_customview.move.MyView;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class ControlActivity extends AppCompatActivity {

    MyView myView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_control);
        myView = new MyView(this);
        setContentView(myView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //关闭线程
        myView.isRun = false;
    }
}
