package com.example.jinhui.androiddemo.day14.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 * Service服务：
 *
 * 非绑定的服务  生命周期   onCreate --> onStartCommand --> onDestroy
 *
 * •运行于后台，没有图形界面。
 •不做耗时操作，实际使用中要开子线程来实现耗时操作。
 •包含有服务的进程，进程级别会被提高
 •分为启动服务与绑定服务两类。

 服务的创建和注册：
 定义一个继承Service的子类，并重写onStartCommand等相关方法

 服务的启动与终止：
 启动服务（非绑定服务）+生命周期

 普通方式启动服务时，启动服务的组件只负责启动停止，其它没有什么关系。
 startService(intent);

 显示意图启动服务:
 Intent intent = new Intent();
 intent.setClass(MainActivity.this, MyService.class);
 startService(intent);  //该方法声明于Context中

 隐式意图启动服务:
 startService(new Intent("com.farsight.android_46_service.DownLoadService"));

 停止服务:
 //该方法声明于Context中，被动停止。
 stopService(intent);

 //stopSelf是Service的实例方法，自己停止。
 stopSelf(); // 例如倒计时，时间到了服务自停！

 *
 */

public class MyService extends Service {

    private static final String TAG = "MyService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        Log.d(TAG, "thread = " + Thread.currentThread().getName());  // 线程是main
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
