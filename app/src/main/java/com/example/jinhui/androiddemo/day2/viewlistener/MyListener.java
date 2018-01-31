package com.example.jinhui.androiddemo.day2.viewlistener;

import android.util.Log;
import android.view.View;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */ // 外部类对象
class MyListener implements View.OnClickListener {

    private static final String TAG = MyListener.class.getSimpleName();

    @Override
    public void onClick(View v) {
        Log.e(TAG, "外部类对象");
//        Toast.makeText(ViewListenerActivity.this, "外部类对象", Toast.LENGTH_SHORT).show();
    }
}
