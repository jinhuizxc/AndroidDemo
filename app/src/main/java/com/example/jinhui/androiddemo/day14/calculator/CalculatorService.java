package com.example.jinhui.androiddemo.day14.calculator;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class CalculatorService extends Service {

    int result;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        int opt01 = intent.getIntExtra("opt01", -1);
        int opt02 = intent.getIntExtra("opt02", -1);

        result = opt01 + opt02;

        return new CalculatorBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public class CalculatorBinder extends Binder {

        public int getResult() {
            return result;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
