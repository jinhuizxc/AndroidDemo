package com.example.jinhui.androiddemo.day16.sendbroadcast;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class CountService extends IntentService {

    public CountService() {
        super("count");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CountService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        int count = 0;
        //发送广播的意图
        Intent broadIntent = new Intent();
        while(count < 10){
            count++;
            //发送广播，携带数据
            broadIntent.putExtra("count", count);
            broadIntent.setAction("activity/service/receiver");
            sendBroadcast(broadIntent);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
