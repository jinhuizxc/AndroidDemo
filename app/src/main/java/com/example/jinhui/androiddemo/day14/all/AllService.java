package com.example.jinhui.androiddemo.day14.all;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 * 启动服务和绑定服务混合使用

 服务既被绑定又被启动情况下的生命周期
 操作示例：
 启动服务后再绑定服务 onCreate onStartCommand onBind
 绑定服务后再启动服务 onCreate onBind onStartCommand
 被启动后没有被停止的服务不能被解绑，但是解绑不会有异常只是不生效
 */

public class AllService extends Service {

    private static final String TAG = "AllService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "service onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "service onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "service onDestroy");
    }


    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG, "service onRebind");
    }
}
