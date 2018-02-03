package com.example.jinhui.androiddemo.day16;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day16.broadcastservice.MyReceiver;
import com.example.jinhui.androiddemo.day16.sendbroadcast.CountService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class BroadcastReceiverActivity extends AppCompatActivity {

    @BindView(R.id.bt_sendbroadcast)
    Button btSendbroadcast;
    @BindView(R.id.bt_registerbroadcast)
    Button btRegisterbroadcast;
    @BindView(R.id.bt_sendbroadcastmore)
    Button btSendbroadcastmore;
    @BindView(R.id.bt_sendbroadcast1)
    Button btSendbroadcast1;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.bt_onemore)
    Button btOnemore;
    @BindView(R.id.bt_order)
    Button btOrder;
    @BindView(R.id.bt_broadcast_service)
    Button btBroadcastService;
    @BindView(R.id.bt_systembroadcast)
    Button btSystembroadcast;
    @BindView(R.id.bt_forcequit)
    Button btForcequit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcastreceiver);
        ButterKnife.bind(this);

        /**
         * 关于动态注册广播
         *
         * 动态注册相对而言较为简单。只需要在java代码中注册即可。
         //创建广播接收器对象
         MyBroad broad = new MyBroad();
         //创建意图过滤器对象，并添加需要过滤的动作
         IntentFilter filter = new  IntentFilter();
         filter.addAction(“farsight");
         //注册广播到系统中
         registerReceiver(broad, filter);
         */

        // 动态注册广播接收器
        registerReceiver(receiver, new IntentFilter("activity/service/receiver"));
    }

    @OnClick({R.id.bt_sendbroadcast, R.id.bt_sendbroadcast1, R.id.bt_registerbroadcast,
            R.id.bt_onemore, R.id.bt_sendbroadcastmore, R.id.bt_order,
            R.id.bt_broadcast_service, R.id.bt_systembroadcast,
            R.id.bt_forcequit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_sendbroadcast:
                doSendBroadcast();
                break;
            case R.id.bt_sendbroadcast1:
                Toast.makeText(this, "见代码注解，但是没有实现", Toast.LENGTH_SHORT).show();
//                doSendBroadcast1();
                break;
            case R.id.bt_registerbroadcast:
                startService(new Intent(this, CountService.class));
                break;
            case R.id.bt_onemore:
                // 用的是MyRecevier,同发送一条广播是同一广播
                Intent intent = new Intent();
                //携带数据
                intent.putExtra("name", "Jack");
                intent.setAction("MyRecevier1");
                //发送广播
                sendBroadcast(intent);
                break;
            case R.id.bt_sendbroadcastmore:
                // 结果：
                // E/Test: 广播接收器01收到广播
                // E/Test: 广播接收器02收到广播
                // E/Test: 广播接收器03收到广播
                sendBroadcast(new Intent("more"));//意图过滤器
                break;
            case R.id.bt_order:
                doOrder();
                break;
            case R.id.bt_broadcast_service:
                sendBroadcast(new Intent(this, MyReceiver.class));
                break;
            case R.id.bt_forcequit:
                Toast.makeText(this, "在广播中弹出dialog失败，待处理", Toast.LENGTH_SHORT).show();
//                sendBroadcast(new Intent("ForceQuitReceiver"));
                break;
            case R.id.bt_systembroadcast:
                /**
                 * 系统广播

                 系统广播:Android平台在特定条件下自动发出的广播，如收到知信时，手机没有电时，手机发现有无线网可用时，手机刚启动好时，等等。

                 系统广播与自己写代码发出的广播没有区别，所以监听系统广播与监听自己用代码发送的广播是完全一样的。所以要想监听到系统广播，只需要查到相应用广播的广播类型就可以了，如果想取得监听到的数据，还得去查看系统广播发送时是怎么装的数据。

                 常见系统广播：发送短信广播，来电广播，开机广播，手机电量改变广播

                 举例，监听wifi的打开与关闭，与wifi的连接无关广播

                 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

                 <receiver android:name="ReceiveNetChangeInfo">
                 <intent-filter >
                 <action android:name="android.net.wifi.STATE_CHANGE"/>
                 </intent-filter>
                 </receiver>
                 */
                Toast.makeText(this, "见代码注解", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /**
     * 发送有序广播
     * 什么是有序广播?
     * 普通广播是完全异步的，可以在同一时刻（逻辑上）被所有接收者接收到，消息传递的效率比较高，
     * 但缺点是不能控制接收的顺序，接收者不能将处理结果传递给下一个接收者，并且无法终止广播,而有序广播可以解决以上问题。
     * 有序广播是用权限控制多个广播接收器接收同一个广播时的接收顺序，
     * 并且可以中止广播(BroadcastReceiver类中的abortBroadcast函数)，
     * 也可以在先监听到的广播接收器里增加数据传给下一个接收的广播接收器(使用setResultExtras和getResultExtras函数)。
     * <p>
     * 有序广播的发送
     * <p>
     * //创建意图对象，并指定接收器的类型。
     * Intent intent = new Intent();
     * intent.setAction("farsight");
     * //创建容器对象，并添加数据
     * Bundle bundle = new Bundle();
     * bundle.putString("school", "三人行");
     * intent.putExtras(bundle);
     * //发送广播
     * sendOrderedBroadcast(intent, null);
     * <p>
     * <p>
     * 在AndroidManifest.xml文件中配置广播接收器。
     * <receiver android:name=“包名类名.OneBroadcastReceiver">
     * <intent-filter android:priority="1000">
     * <action android:name="farsight"></action>
     * </intent-filter>
     * </receiver>
     * <p>
     * <receiver android:name=“包名类名.TwoBroadcastReceiver">
     * <intent-filter android:priority="999">
     * <action android:name="farsight"></action>
     * </intent-filter>
     * </receiver>
     * <p>
     * 在广播接收器配置的<intent-filter>标签中都有属性 android:priority的配置，该属性配置的是广播接收器的优先级，优先级的值范围是-1000到+1000之间,优先级高的广播接收器会先接收到广播。
     * <p>
     * <p>
     * 有序广播的其它注意事项:
     * 有序广播被广播接收器接收时，广播接收器注册时也可以不设置监听优先级即<intent-filter android:priority="1000">中的android:priority属性不用配置，这样仍然可以监听到广播，只是这样一来监听的顺序就是另外的一会事了。也就是说，也可以按照监听普通的广播一样去监有序广播。
     * 怎么样才能判断一个广播是有序还是无序呢? BoradcastReceiver中函数 public final boolean isOrderedBroadcast() ,可以判断当前进程正监听到的广播是否有序，如果有序返回true,无序返回false。
     * 多个广播接收器监听有序广播时，如果没有按照监听有序广播的形式去监听，即在注册广播接收器时不设置优先级，则不同项目中的广播接收器的监听顺序是任意的，但是同一个项目中的广播接收器是先注册的先监听到广播。
     */

    // 结果：
    // E/Test: 广播接收器01收到广播
    // E/Test: 广播接收器03收到广播
    // E/Test: 广播接收器02收到广播
    private void doOrder() {
        sendOrderedBroadcast(new Intent("order"), null);
    }

    // 根据之前的笔记,是独立的2个demo，
    // 在57里注册广播，在58里发送广播，这样实现跨进程,但是我没实现
    private void doSendBroadcast1() {
        Intent intent = new Intent();
        //携带数据
        intent.putExtra("name", "Jack");
        intent.setAction("com.farsight.android_57_broadcastreceiver.MyRecevier");
        //发送广播
        sendBroadcast(intent);
    }

    private void doSendBroadcast() {
        Intent intent = new Intent();
        //携带数据
        intent.putExtra("name", "Jack");
        intent.setAction("MyRecevier");
        //发送广播
        sendBroadcast(intent);
    }

    // 动态注册广播
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int count = intent.getIntExtra("count", -1);
            tvCount.setText(String.valueOf(count));
        }
    };
}
