package com.example.jinhui.androiddemo.day15;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day15.aidl.IWeather;
import com.example.jinhui.androiddemo.day15.aidl.WeatherService;
import com.example.jinhui.androiddemo.day15.foreground.ForegroundService;
import com.example.jinhui.androiddemo.day15.intentservice.MyService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class Service2Activity extends AppCompatActivity {

    private static final String TAG = "Service2Activity";
    @BindView(R.id.bt_aidl)
    Button btAidl;
    @BindView(R.id.bt_musicplayer)
    Button btMusicplayer;
    @BindView(R.id.bt_startforefround)
    Button btStartforefround;
    @BindView(R.id.bt_stopforeground)
    Button btStopforeground;
    @BindView(R.id.bt_startintentservice)
    Button btStartintentservice;
    @BindView(R.id.bt_stopintentservice)
    Button btStopintentservice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_aidl, R.id.bt_startforefround, R.id.bt_stopforeground,
            R.id.bt_musicplayer, R.id.bt_startintentservice, R.id.bt_stopintentservice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_aidl:
                bindService(new Intent(this, WeatherService.class),
                        conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.bt_startforefround:
                startService(new Intent(this, ForegroundService.class));
                break;
            case R.id.bt_stopforeground:
                stopService(new Intent(this, ForegroundService.class));
                break;
            case R.id.bt_startintentservice:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.bt_stopintentservice:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.bt_musicplayer:
                break;
        }
    }

    ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            IWeather weather = IWeather.Stub.asInterface(service);
            String info = null;
            try {
                info = weather.getWeatherInfo();
                Log.e(TAG, "info = " + info); // E/Service2Activity: info = 武汉：晴
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
