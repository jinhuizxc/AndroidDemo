package com.example.jinhui.androiddemo.day15.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 * AIDL通信
 * 什么是AIDL:
 * aidl是 Android Interface definition language的缩写。AIDL并不是一种真正的语言，它是一种android内部进程通信接口的描述语言，语法与Java相似。通过它我们可以定义进程间的通信接口。
 绑定服务中客户端与服务端必须在同一个项目中，而AIDL可以实现跨项目的绑定。

 跨进程通信实现步骤（服务器端）：
 1.创建IMyService.aidl文件,内容为
 package com.fs.aidl.service;
 interface IMyService
 {
 String getValue(String s);
 }

 定义好上面的AIDL接口后，将该文件放入到com.fs.aidl. service文件夹后。ADT工具会自动在gen目录的包下生成一个名为IMyService.java的接口文件。

 在生成的IMyService.java接口里包含了一个Stub内部类，该类实现了IBinder和IMyService两个接口。Stub类将会作为远程Service的回调类—--实现了Ibinder接口，因此可以作为onBind()方法的返回值。

 aidl文件写法跟java代码类似，但是这里有一点值得注意的就是它可以引用其它aidl文件中定义的接口，但是不能够引用你的java类文件中定义的接口


 2.创建WeatherService.java文件
 public class WeatherService extends Service {
@Nullable
@Override
public IBinder onBind(Intent intent) {
return new MyStub();
}

// 报错rebuild一下
public class MyStub extends IWeather.Stub{

@Override
public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

}

@Override
public String getWeatherInfo() throws RemoteException {
return "武汉：晴";
}

}
}

 3.配置服务
 <service android:name=".MyService" >
 <intent-filter>
 <action android:name=
 "com.fs.aidl.service.MyService" />
 </intent-filter>
 </service>


 跨进程通信实现步骤（客户端）：
 1.将服务端项目中的MyService.java连同包一起复制出来粘贴在客户端项目中。

 2.创建Activity，绑定服务。创建ServiceConnection对象。
 private ServiceConnection serviceConnection = new ServiceConnection() {
 // @Override
 public void onServiceConnected(ComponentName name, IBinder  service)
 {
 myService = IMyService.Stub.asInterface(service);
 btnInvokeAIDLService.setEnabled(true);
 }

 // @Override
 public void onServiceDisconnected(ComponentName name) {

 }
 };

 3.实现按键监听方法
 // @Override
 public void onClick(View view) {
 switch (view.getId()) {
 case R.id.bt_bind:               //绑定AIDL服务
 bindService(new Intent(“AIDL.MyService")，
 serviceConnection, Context.BIND_AUTO_CREATE);
 break;
 case R.id.bt_invoke_service:    //调用AIDL服务
 try {
 textView.setText(myService.getValue("AIDL  Service"));
 } catch (Exception e) {
 }
 break;
 }
 }






 *
 */

public class WeatherService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyStub();
    }

    // 报错rebuild一下
    public class MyStub extends IWeather.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getWeatherInfo() throws RemoteException {
            return "武汉：晴";
        }

    }
}
