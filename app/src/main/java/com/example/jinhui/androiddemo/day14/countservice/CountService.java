package com.example.jinhui.androiddemo.day14.countservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 */

public class CountService extends Service {

    private static final String TAG = "CountService";

    int max;
    // 注意：把关于isOnlyOneThread的一切都注释掉，
    // 再次运行也是没有问题的，当初写这个应该是学习boolen的对象的控制吧
    boolean isOnlyOneThread = true;
    // 控制计数
    boolean isRun;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        Log.e(TAG, "thread = " + Thread.currentThread().getName());  // thread = main

        max = intent.getIntExtra("max", -1);

        if(isOnlyOneThread) {
            // 计数线程start开始后将isOnlyOneThread = false
            isRun = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    doCount();
                }
            }).start();
            isOnlyOneThread = false;
            Log.e(TAG, "isOnlyOneThread = " + isOnlyOneThread);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void doCount() {
        int count = 0;
        while(count < max){
            count++;
            if (!isRun){
                return;
            }
            Log.e(TAG, "count = " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 关闭服务
        stopSelf();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "service onDestroy");
        isRun = false;
        isOnlyOneThread = true;
    }
}
