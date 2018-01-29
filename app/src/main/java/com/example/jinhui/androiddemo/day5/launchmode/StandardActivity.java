package com.example.jinhui.androiddemo.day5.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 * <p>
 * Task(任务):
 * 在Android中是通过任务（Task）来管理活动，Task就是一系列活动的集合。每个应用程序运行都会对应创建一个Task。
 * 如果在应用程序的运行过程中，用户点击了Home键，那么，该应用程序
 * 的Task就会被调度到后台，BackStack中的所有Activity都进入停止状态。虽
 * 然，被调度到了后台，但是BackStack中的所有Activity还是存在的（除非，系
 * 统因为内存不足销毁掉了Activity），用户可以通过Home界面中的图标将后台的Task再次调度到前台。
 * <p>
 * 返回栈（BackStack）
 * Android通过BackStack来管理这些Task，Task中的活动会按启动的先后顺序，依次保存到BackStack中，每个Task会有自己对应的id号（非R文件中），可以通过getTaskId（）方法获得。
 * <p>
 * 栈：
 * 栈是一种后进先出的数据结构，每当新建一个新活动时，该活动就会在
 * BackStack中入栈，并且处于栈顶位置。当按下back键或者finish该活动时，这个活动就会出栈，这时下一个活动就会处于栈顶位置。
 * <p>
 * <p>
 * Activity的启动模式对我们来说是一个新概念，在实际开发过程中会给的启动模式对我们来说是一个新概念，在实际开发过程中会给这些Activity设定恰当的启动模式 设定恰当的启动模式来实现特定的需求。
 * <p>
 * 启动模式一共有四种，分别是standard 、singleTop 、singleTask 和 singleInstance，
 * <p>
 * 可在AndroidManifest.xml中通过给<activity>标签指定。通过android:launchMode属性来选择启动模式
 * <activity
 * android:name=".MainActivity"
 * android:label="@string/app_name"
 * android:launchMode="standard">
 */

public class StandardActivity extends AppCompatActivity {

    private static final String TAG = StandardActivity.class.getSimpleName();
    @BindView(R.id.bt)
    Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "StandardActivity onCreate");
        setContentView(R.layout.activity_standard);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt)
    public void onViewClicked() {
        startActivity(new Intent(this, StandardActivity.class));
    }
}
