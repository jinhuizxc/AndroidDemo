package com.example.jinhui.androiddemo.day3_interface.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 * <p>
 * 带值跳转
 * <p>
 * 上面我们只是介绍了两个界面之间一个纯粹的跳转，
 * 但是在我们实际使用APP的过程中，一个Activity启动例外一个Activity时，常常会传输一些数据。
 * 对于Activity而言，在Activity之间进行数据交换很简单，只需要将数据放入Intent对象中即可。
 * Intent提供了多个重载的方法来“携带”数据，下面我们通过一个实例来
 * 介绍如何实现Activity之间的数据传递。
 */

public class Jump2Activity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump2);
        ButterKnife.bind(this);

        // 获得意图对象
        Intent intent = this.getIntent();
        String string = intent.getStringExtra("msg");
        textView.setText(string);
    }
}
