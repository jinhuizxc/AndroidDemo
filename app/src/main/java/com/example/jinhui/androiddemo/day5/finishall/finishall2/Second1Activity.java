package com.example.jinhui.androiddemo.day5.finishall.finishall2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day5.finishall.Tool;
import com.example.jinhui.androiddemo.day5.finishall.finishall1.ThirdActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */

public class Second1Activity extends BaseActivity {

    @BindView(R.id.bt_second)
    Button btSecond;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceond);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_second)
    public void onViewClicked() {
        startActivity(new Intent(this, Third1Activity.class));
    }
}
