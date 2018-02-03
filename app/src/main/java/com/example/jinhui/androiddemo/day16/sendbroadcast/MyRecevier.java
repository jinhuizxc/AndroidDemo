package com.example.jinhui.androiddemo.day16.sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 *
 * 广播接收器
 * 继承BroadcastReceiver实现：
 * onReceive(Context context, Intent intent)方法
 *
 *
 * android的广播机制类似于电台广播，电台在指定的频率上发送广播，收音机调到相应的频率上就可以接收到广播。

 android的广播机制充许在手机系统中发送一个广播，并且可以在手机系统中接收到广播。

 android发送广播时要指定广播的类型，相当于电台发送广播时要指定频率。

 android广播接收器用于接收广播。广播接收器也要指定广播类型，这样才能指收到该广播类型的广播。就像收音机要调到相应的频率上才能听到该频率上的广播信息一样。

 PS:应用程序安装广播的系统进程关闭：3.1版本前能接收广播，3.1之后不能接收广播

 发送广播：
 不带信息发送：
 Intent intent = new Intent();    //创建意图用于发送广播
 intent.setAction(“farsight”);  //参数为广播类型，任意字符串
 sendBroadcast(intent);           //发广播

 附带信息广播的发送：
 Intent intent = new Intent();
 //添加信息内容
 Bundle bundle = new Bundle();
 bundle.putString(“name”, “微微");
 bundle.putInt("age", 20);
 intent.putExtras(bundle);

 sendBroadcast(intent);
 ###############################
 Intent intent = new Intent();
 //携带数据
 intent.putExtra("name", "Jack");
 intent.setAction(".MyRecevier");
 //发送广播
 sendBroadcast(intent);


 接收广播：
 当广播发出后，可以在发广播的同一台手机上的项目中监听该广播，当监听到对应的广播类型即可收到广播。但是收到广播的前提是注册相对应的广播接收器接收广播(BroadcastReceiver)并实现onReceive方法 。
 onReceive(Context context, Intent intent)方法

 public class MyBroadcastReceiver extends BroadcastReceiver {
 当监听到广播以后，该方法被自动回调，当方法被调用了，也说明了监听到了广播
@Override
public void onReceive(Context context, Intent intent) {
        String type = intent.getAction();  //取出监听到的广播类型
        if("farsight".equals(type)) {
        Toast.makeText(context, "监听到的广播类型是:"+type,Toast.LENGTH_LONG).show();
        //取广播数据
        Bundle bundle = intent.getExtras();
        int age = bundle.getInt("age");
        String name = bundle.getString("name");
        Toast.makeText(context,"age:"+age+",name:"+name,Toast.LENGTH_LONG).show();
        }
        }
        }



 */

public class MyRecevier extends BroadcastReceiver {

    private static final String TAG = "MyRecevier";

    // 接收广播
    @Override
    public void onReceive(Context context, Intent intent) {

        String name = intent.getStringExtra("name");
        Log.e(TAG, "onReceive");
        Toast.makeText(context, "收到广播：" + name, Toast.LENGTH_SHORT).show();
    }
}
