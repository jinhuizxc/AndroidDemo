package com.example.jinhui.androiddemo.day5.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 * <p>
 * singleInstance又叫共享引用，
 * singleInstance模式是这四种模式中最为特殊的，大家需要多费点脑细胞来理解。
 * 指定为singleInstance模式的活动启动时会用一个新的BackStack来管理该活动。
 */

public class SingleInstanceActivity extends AppCompatActivity {

    @BindView(R.id.button5)
    Button button5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinstance);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button5)
    public void onViewClicked() {
        // 由于SingleInstanceActivity为SingleInstance模式，需要采取下面这种操作，
        // 界面：MainActivity->ActivityActivity->SingleInstanceActivity->NewActivity
        // 产生栈1：MainActivity->ActivityActivity->NewActivity 栈2：SingleInstanceActivity
        // 最后点击返回键先从栈1开始出栈，然后是栈2，需要4次退出应用
        startActivity(new Intent(this, NewActivity.class));
    }
}
