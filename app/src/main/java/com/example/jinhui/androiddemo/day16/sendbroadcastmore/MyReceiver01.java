package com.example.jinhui.androiddemo.day16.sendbroadcastmore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class MyReceiver01 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Test", "广播接收器01收到广播");
    }
}
