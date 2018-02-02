package com.example.jinhui.androiddemo.day15.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 * <p>
 * MyService继承IntentService实现：
 * 构造MyService、onHandleIntent2个方法
 *
 * IntentService

 服务中的代码都是默认运行在主线程当中的，如果直接在服务里去处理一些耗时的逻辑，就很容易出现ANR（Application NotResponding）的情况。
 IntentService是Service类的子类，用来处理异步请求。客户端可以通过startService(Intent)方法传递请求给IntentService。IntentService在onCreate()函数中通过HandlerThread单独开启一个线程来处理所有Intent请求对象（通过startService的方式发送过来的）所对应的任务，这样以免事务处理阻塞主线程。执行完所一个Intent请求对象所对应的工作之后，如果没有新的Intent请求达到，则自动停止Service；否则执行下一个Intent请求所对应的任务。
 public class MyIntentService extends IntentService {

 public MyIntentService() {
 //设置子线程名
 super("MyIntentService");
 }

 @Override
 protected void onHandleIntent(Intent intent) {
 // TODO Auto-generated method stub


 Log.d("Test", "thread = " + Thread.currentThread().getName());

 }

 @Override
 public void onCreate() {
 // TODO Auto-generated method stub
 super.onCreate();
 Log.d("Test", "service onCreate");
 }

 @Override
 public void onStart(Intent intent, int startId) {
 // TODO Auto-generated method stub
 super.onStart(intent, startId);

 Log.d("Test", "service onStart");
 }

 @Override
 public void onDestroy() {
 // TODO Auto-generated method stub
 super.onDestroy();
 Log.d("Test", "service onDestroy");
 }
 }
 */

public class MyService extends IntentService {

    private static final String TAG = "MyService";

    // manifest报本servicem没有默认构造可以进行这样的处理
    public MyService() {
        super("aaaa");  // 字符串随便写
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    /**
     * 补充：//name 子线程名
     */
    public MyService(String name) {
        super(name);
        Log.e(TAG, "name = " + name);
    }

    /**
     * 该方法运行在子线程
     *
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e(TAG, "thread name = " + Thread.currentThread().getName());
        // E/MyService: thread name = IntentService[aaaa]
        int count = 0;
        while (count < 10) {
            count++;
            Log.e(TAG, "count = " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
