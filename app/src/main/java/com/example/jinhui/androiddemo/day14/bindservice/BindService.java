package com.example.jinhui.androiddemo.day14.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 * 绑定服务
 * MyBinder
 * 点击service onCreate
 * E/BindService: service onBind
 * E/BindService: count =1
 * E/BindService: service binder = com.example.jinhui.androiddemo.day14.bindservice.BindService$MyBinder@13446d8
 * E/Service1Activity: onServiceDisconnected
 * E/BindService: count =2
 *
 *
 * •绑定服务可以解决绑定服务的组件与服务进行通信，绑定服务只能是在同一个项目中。
 •底层是Binder驱动进行进程间通信。
 •具体是在Service中创建一个内部类(IBinder接口实现类)， 在Service的onBinder返回该内部类对象；该对象会传到客户端,客户端通过该对象调用该对象的方法实现与Service的通信。
 •客户端通过ServiceConnection得到Service中onBinder返回的对象。
 Binder implements IBinder,IBinder为一个接口,myBinder是自己定义的类继承Binder

 实现步骤:
 1.在Service中创建一个内部类(IBinder接口实现类)；
 2.在Service的onBinder返回该内部类对象；该对象会传到客户端,
 客户端通过该对象调用该对象的方法实现与Service的通信。
 3.客户端通过ServiceConnection得到Service中onBinder返回的对象。
 如果service和访问者之间需要进行方法调用或者数据传递时用应当使用bindSrvice（）和unbindService（）方法绑定与解绑服务


 绑定服务注意事项:
 组件绑定服务后，一但组件被销毁，会自动解除与服务的绑定
 不能跨项目实现绑定(AIDL可以跨项目)
 ServiceConnection中onServiceDisconnected方法只能在异常情况不会被调用
 绑定服务也是服务，所以别忘记配置


 服务的生命周期:
 Service与Activity一样都是Context派生出来的，也都有自己的生命周期。

 Service生命周期方法解释

 //必须实现的方法，返回Ibinder对象，应用程序可以通过该对象与Service组件通信，
 //使用StartService启动的服务该方法不会被回调。
 public IBinder onBind(Intent intent)

 //当该Service第一次被创建后将立即回调该方法。
 public void onCreate()

 //该方法早期版本为public void onStart (Intent intent, int startId)，
 //当每次调用StartService(intent)启动该服务时，都会回调该方法。
 public int onStartCommand(Intent intent, int flags, int startId)

 //当service被关闭之前该方法被回调。
 public void onDestroy()

 //当该Service上绑定的所有客户端都断开连接时，该方法被回调。
 public boolean onUnbind(Intent intent)

 启动服务（非绑定的服务）
 普通方式启动服务时，启动服务的组件只负责启动停止，其它没有什么关系。

 绑定服务
 绑定服务可以解决绑定服务的组件与服务进行通信，绑定服务只能是在同一个项目中。
 底层是Binder驱动进行进程间通信。
 具体是在Service中创建一个内部类(IBinder接口实现类)， 在Service的onBinder返回该内部类对象；该对象会传到客户端,客户端通过该对象调用该对象的方法实现与Service的通信。
 客户端通过ServiceConnection得到Service中onBinder返回的对象。

 绑定服务使用bindService方法
 解绑使用unBindService方法或者启动服务的组件被销毁

 服务中int onStartCommand(Intent intent, int flag, int startID)有三种种返回值：当Service被异常kill掉后

 Service.STARTSTICKY：(默认值)
 当Service因为内存不足而被系统kill后，接下来未来的某个时间内，当系统内存足够可用的情况下，系统将会尝试重新创建此Service，一旦创建成功后将回调onStartCommand(...)方法，但其中的Intent将是null，pendingintent除外。
 Service.STARTREDELIVER_INTENT：
 系统会自动偿试重新启动服务，并为intent传入Service被kill之前的intent的值。
 Service.STARTNOTSTICKY：
 当Service因为内存不足而被系统kill后，接下来未来的某个时间内，即使系统内存足够可用，系统也不会尝试重新创建此Service。除非程序中Client明确再次调用startService(...)启动此Service。
 如果service和访问者之间需要进行方法调用或者数据传递时应当使用bindSrvice（）和unbindService（）方法开启关闭服务。
 bindService(Intent service, ServiceConnection conn, int flags)

 service: 通过Intent指定需要启动的服务。
 conn: ServiceConnection对象，用于监听Service与访问者之间的连接情况。
 flag: 指定绑定服务时是否自动创建Service（如果服务还没有创建就自动创建）该参数一般为BINDAUTOCREATE。
 绑定服务注意事项
 组件绑定服务后，一但组件被销毁，会自动解除与服务的绑定
 不能跨项目实现绑定(AIDL可以跨项目)
 ServiceConnection中onServiceDisconnected方法只能在异常情况不会被调用
 绑定服务也是服务，所以别忘记配置

 *
 *
 *
 *
 *
 */

public class BindService extends Service {

    private static final String TAG = "BindService";

    private int max = 100;
    private int count;
    // 控制计数，解绑就停止计数
    boolean isRun;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "service onBind");

        MyBinder binder = new MyBinder();

        Log.e(TAG, "service binder = " + binder);

        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "service onCreate");
        new Thread(new Runnable() {   //线程放在onCreate()方法里,谨记。
            @Override
            public void run() {
                isRun = true;
                //计数
                while(count < 20){
                    count++;
                    if (!isRun){
                        return;
                    }
                    Log.e(TAG, "count =" + count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    /**
     * 绑定服务时，此方法不执行！谨记！
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * Binder implements IBinder,IBinder为一个接口,
     * myBinder是自己定义的类继承Binder
     *
     */
    public class MyBinder extends Binder{

        public int getMax() {
            return max;
        }

        public int getCount() {
            return count;
        }
    }


    // 解绑服务会先后执行：
    // E/BindService: servce onUnbind
    // E/BindService: service onDestroy
    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "servce onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRun = false;
        Log.e(TAG, "service onDestroy");
    }
}
