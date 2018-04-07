package com.example.jinhui.androiddemo.day21_adapter_footer_header.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class XScrollViewActivity extends AppCompatActivity {


    public static void launch(Context context) {
        context.startActivity(new Intent(context, XScrollViewActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xscrollview);
    }
}
