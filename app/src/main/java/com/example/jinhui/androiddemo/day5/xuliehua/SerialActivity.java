package com.example.jinhui.androiddemo.day5.xuliehua;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */

public class SerialActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        //获取bundle对象
        Bundle bundle = intent.getExtras();

        //获取传递过来的类的对象
        assert bundle != null;
        Surprise surprise = (Surprise) bundle.getSerializable("data");
        Me me = bundle.getParcelable("me");

        //获取类里的数据
        assert surprise != null;
        String name = surprise.getName();
        int number = surprise.getNumber();

        assert me != null;
        String name1 = me.getName();
        String msg = me.getMsg();

        textView1.setText(name);
        textView2.setText(String.valueOf(number));
        textView3.setText(name1);
        textView4.setText(msg);
    }
}
