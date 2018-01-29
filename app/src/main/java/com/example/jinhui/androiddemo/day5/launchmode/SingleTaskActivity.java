package com.example.jinhui.androiddemo.day5.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day5.ActivityActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 * <p>
 * singleTask又叫共享栈，当活动的启动模式指定为 singleTask，每次启动该
 * 活动时系统首先会在BackStack中检查是否存在该活动的实例，如果发现已经
 * 存在则直接使用该实例，并把在这个活动之上的所有活动统统出栈，如果没有发现就会创建一个新的活动实例。
 * 通过设置singleTask，能确保栈中只存在一个该活动的实例。singleTask适合作为程序入口点。例如一些程序的主界面 。
 */

public class SingleTaskActivity extends AppCompatActivity {

    private static final String TAG = SingleTaskActivity.class.getSimpleName();

    @BindView(R.id.button4)
    Button button4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletask);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.button4)
    public void onViewClicked() {
        // 由于SingleTaskActivity为SingleTask模式，需要采取下面这种操作，
        // 界面：MainActivity->ActivityActivity->SingleTaskActivity->ActivityActivity->SingleTaskActivity
        // 最后会剩下MainActivity->ActivityActivity->SingleTaskActivity 3个栈，返回3次退出应用
        startActivity(new Intent(this, ActivityActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
