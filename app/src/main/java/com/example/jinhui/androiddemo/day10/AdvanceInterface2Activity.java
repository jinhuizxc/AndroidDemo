package com.example.jinhui.androiddemo.day10;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day10.style.StyleActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 */

public class AdvanceInterface2Activity extends AppCompatActivity {

    private static final String TAG = AdvanceInterface2Activity.class.getSimpleName();
    @BindView(R.id.bt_toast)
    Button btToast;
    @BindView(R.id.bt_customtoast)
    Button btCustomtoast;
    @BindView(R.id.bt_notification)
    Button btNotification;


    // 再按一次退出
    long time;
    @BindView(R.id.bt_moreToast)
    Button btMoreToast;
    @BindView(R.id.bt_cancle)
    Button btCancle;

    //通知管理器
    NotificationManager notiManager;
    @BindView(R.id.bt_welcome)
    Button btWelcome;
    @BindView(R.id.bt_style)
    Button btStyle;
    @BindView(R.id.bt_readJson)
    Button btReadJson;
    @BindView(R.id.bt_makeJson)
    Button btMakeJson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanceinterface2);
        ButterKnife.bind(this);


//        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 初始化通知对象
        notiManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @OnClick({R.id.bt_toast, R.id.bt_customtoast, R.id.bt_moreToast,
            R.id.bt_notification, R.id.bt_cancle,
            R.id.bt_welcome, R.id.bt_style, R.id.bt_readJson,
            R.id.bt_makeJson})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_toast:
                Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.bt_customtoast:
                Toast toast1 = Toast.makeText(this, "自定义Toast", Toast.LENGTH_SHORT);
                // 自定义Toast视图
                View view1 = LayoutInflater.from(this).inflate(R.layout.my_toast, null);
                // 设置View
                toast1.setView(view1);
                // 位置
                toast1.setGravity(Gravity.BOTTOM, 0, 50);
                toast1.show();
                break;
            case R.id.bt_moreToast:
                startActivity(new Intent(this, MoreToastActivity.class));
                break;
            case R.id.bt_notification:
                doNotification();
                break;
            case R.id.bt_cancle:
                //取消id=1的通知
                notiManager.cancel(1);
                break;
            case R.id.bt_welcome:
                startActivity(new Intent(this, WelcomeActivity.class));
                break;
            case R.id.bt_style:
                startActivity(new Intent(this, StyleActivity.class));
                break;
            case R.id.bt_readJson:
                //解析Json
                readJson("info.json");
                break;
            case R.id.bt_makeJson:
                //打包json	
                //{"info": {"name":"think in java", "price":100, "author":["Jack", "Lily", "Rico"]}, "number":50}	
                makeJson();
                break;
        }
    }

    private void makeJson() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("number", 50);

            JSONObject infoObj = new JSONObject();
            infoObj.put("name", "think in java");
            infoObj.put("price", 100);

            //打包Json数组
            JSONArray array = new JSONArray();
            array.put(0, "Jack");
            array.put(1, "Lily");
            array.put(2, "Rico");
            infoObj.put("author", array);

            obj.put("info", infoObj);
            //  E/AdvanceInterface2Activity:
            // {"number":50,"info":{"name":"think in java","price":100,"author":["Jack","Lily","Rico"]}}
            Log.e(TAG, obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * E/AdvanceInterface2Activity:
     * {"info": {"name":"jack", "age":20, "salary":3000, "favor":["film", "code","run"]}}
     E/AdvanceInterface2Activity: name = jack
     E/AdvanceInterface2Activity: favor = film
     E/AdvanceInterface2Activity: favor = code
     E/AdvanceInterface2Activity: favor = run
     * @param jsonFile
     */
    private void readJson(String jsonFile) {
        try {
            //接收文件，用InputStream
            InputStream is = this.getResources().getAssets().open(jsonFile);
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String json = br.readLine();
            Log.e(TAG, json);

            //解析
            //创建json对象,将json字符串封装在obj对象中
            JSONObject obj = new JSONObject(json);
            //取key为info的内容
            JSONObject infoObj = obj.getJSONObject("info");
            //取出名字
            String name = infoObj.getString("name");
            Log.e(TAG, "name = " + name);
            //取出年龄
            int age = infoObj.getInt("age");
            //取出收入
            int salary = infoObj.getInt("salary");
            //取出爱好------就这两个，，getJSONObject/getJSONArray
            JSONArray array = infoObj.getJSONArray("favor");
            for (int i = 0; i < array.length(); i++) {
                String favor = array.getString(i);
                Log.e(TAG, "favor = " + favor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Notification是显示在手机状态栏的消息（手机状态栏位于手机最顶端），代表一种全局效果的通知。
     * <p>
     * 通知管理器NotificationManager ：
     * //通知管理器
     * NotificationManager notificationManager;
     * notificationManager = (NotificationManager)
     * this.getSystemService(Context.NOTIFICATION_SERVICE);
     * <p>
     * 状态栏：
     * //设置状态栏的图片
     * builder.setSmallIcon(R.drawable.ic_launcher);
     * //设置状态栏的文字
     * builder.setTicker("紧急通知！");
     * <p>
     * 通知栏的内容：
     * 图标  标题  内容  时间  点击后响应
     * <p>
     * //设置通知栏
     * //设置时间
     * builder.setWhen(System.currentTimeMillis());
     * //设置标题
     * builder.setContentTitle("通知栏通知");
     * //设置通知内容
     * builder.setContentText("我来自Notification");
     * <p>
     * //点击后自动取消
     * //builder.setAutoCancel(true);
     * <p>
     * //取出通知对象
     * Notification notification = builder.getNotification();
     * <p>
     * //发送id=1的通知-----------显示通知栏
     * notificationManager.notify(1, notification);
     * //取消id=1的通知------------取消通知栏
     * notificationManager.cancel(1);
     */

    private void doNotification() {
        //发送通知
        Notification.Builder builder = new Notification.Builder(this);
        //设置状态栏的图片
        builder.setSmallIcon(R.drawable.ic_launcher);
        //设置状态栏的文字
        builder.setTicker("紧急通知！");
        //设置通知面板
        //设置时间
        builder.setWhen(System.currentTimeMillis());
//        //点击后自动取消
        // 这里不知为啥点击不能自动取消了，是api太旧了么？
//        builder.setAutoCancel(true);
        //设置标题
        builder.setContentTitle("通知栏通知");
        //设置通知内容
        builder.setContentText("我来自Notification");
        //取出通知对象
        Notification notification1 = builder.getNotification();
        //发送id=1的通知
        notiManager.notify(1, notification1);
        // 测试第2条通知
//        Notification notification2 = builder.getNotification();
//        //发送id=2的通知
//        notiManager.notify(2, notification2);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "event.getEventTime() =" + event.getEventTime());
            if (event.getEventTime() - time < 2000) {
                finish();
                Log.e(TAG, "finish");
            } else {
                time = event.getEventTime();
                Log.e(TAG, "time");
            }
        }
        return true;   // 必须置为true，不然点击物理键直接就退出界面了

        // 如果是return super.onKeyDown(keyCode, event);
        // 这行的话执行的话是：
        // E/AdvanceInterface2Activity: event.getEventTime() =354359985
        // E/AdvanceInterface2Activity: time，
        // 然后界面退出
//        return super.onKeyDown(keyCode, event);

    }
}
