package com.example.jinhui.androiddemo.day15.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 * 前台服务

 什么是前台服务
 服务几乎都是在后台运行的，一直以来它都是默默地做着辛苦的工作。但是服务的系统优先级还是比较低的，当系统出现内存不足的情况时，就有可能会回收掉正在后台运行的服务。如果你希望服务可以一直保持运行状态，而不会由于系统内存不足的原因导致被回收，就可以考虑使用前台服务。
 什么时候会用前台服务
 前台服务和普通服务最大的区别就在于，它会一直有一个正在运行的图标在系统的状态栏显示，下拉状态栏后可以看到更加详细的信息，非常类似于通知的效果。当然有时候你也可能不仅仅是为了防止服务被回收掉才使用前台服务的，有些项目由于特殊的需求会要求必须使用前台服务，比如说墨迹天气，它的服务在后台更新天气数据的同时，还会在系统状态栏一直显示当前的天气信息。
 创建前台服务

 @Override
 public void onCreate() {
 super.onCreate();

 Builder builder = new Builder(this);
 builder.setTicker("通知");
 builder.setSmallIcon(R.drawable.ic_launcher);
 builder.setWhen(System.currentTimeMillis());
 builder.setAutoCancel(true);
 builder.setContentTitle("标题");
 builder.setContentText("正文");

 Notification notification = builder.getNotification();

 //设置前台服务
 startForeground(1, notification);
 }
 */

public class ForegroundService extends Service {

    private static final String TAG = "ForegroundService";
    //通知管理器
    NotificationManager notiManager;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        // 初始化通知对象
        notiManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setTicker("通知");
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle("标题");
        builder.setContentText("正文");

        Notification notification = builder.getNotification();

        // 设置前台服务
        startForeground(1, notification);
        //发送id=1的通知
        notiManager.notify(1, notification);
        Log.e(TAG, "设置前台服务完成");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
