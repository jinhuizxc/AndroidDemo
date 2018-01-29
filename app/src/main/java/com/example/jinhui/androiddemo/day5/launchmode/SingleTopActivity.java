package com.example.jinhui.androiddemo.day5.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day5.ActivityActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 * <p>
 * singleTop又叫共享栈顶模式，
 * 在启动这一类活动时，系统会先检测当前Task，看该Task的栈顶是不是该活动的实例，如果是的话，就不需要再创建该活动实例。
 */

public class SingleTopActivity extends AppCompatActivity {

    private static final String TAG = SingleTopActivity.class.getSimpleName();
    @BindView(R.id.button3)
    Button button3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletop);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button3)
    public void onViewClicked() {
        // 因为SingleTopActivity在栈顶，不会在创建
//        startActivity(new Intent(this, SingleTopActivity.class));
        // 跳转至ActivityActivity，栈中有3个activity,
        // 分别是ActivityActivity、 SingleTopActivity、ActivityActivity。
        startActivity(new Intent(this, ActivityActivity.class));
    }
}
