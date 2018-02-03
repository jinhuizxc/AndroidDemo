package com.example.jinhui.androiddemo.day16.orderbroadcast1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class OrderBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Test", "广播接收器02收到广播");
    }
}