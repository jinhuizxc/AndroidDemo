package com.example.jinhui.androiddemo.day4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */

public class FullscreenJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 但要注意的是：在代码中设置的话，
         * 设置无标题和设置全屏的两段代码要放置在 setContentView(R.layout.main)
         * 这段代码的前面,要不然会报错。在代码中设置全屏不会改变背景颜色。
         */
        // 设置无标题,即无状态栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fullscreenjava);
    }
}
