package com.example.jinhui.androiddemo.day16.broadcastservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 * <p>
 * 广播接收器中不能做耗时的操作，广播接收器生命周期最多10s，不要开线程。
 * <p>
 * 广播接收器生命周期
 * <p>
 * 当监听到广播时，自动创建广播监收器对象。
 * 当广播监收器对象被创建后，立刻调用onReceiver方法,该方法运行时间不能操作10秒钟，否则要报错，我们不要在该方法中新创建子线程，因为该方法最多可以执行10秒钟，子线程也会随之结束。如果要在该方法中执行长时间的操作，我们最好的办法是在该方法中启动一个服务，然后在服务中开辟子线程来执行。
 * 当onReceiver执行结束后，就会执行onDistroy函数。
 * 当onDistroy执行结束后，系统会销毁广播接收器对象，至此，广播接收器生命周期结束。
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // 测试：正常计数没有问题
//        int count = 0;
//        while (count < 15){
//            count++;
//            Log.e("Test", "count = " + count);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int count = 0;
//                while (count < 15) {
//                    count++;
//                    Log.e("Test", "count = " + count);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
        //启动服务
        context.startService(new Intent(context, MyService.class));
    }

}
