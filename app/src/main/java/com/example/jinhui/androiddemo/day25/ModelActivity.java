package com.example.jinhui.androiddemo.day25;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day25.mvc.MVCActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class ModelActivity extends AppCompatActivity {

    @BindView(R.id.bt_mvc)
    Button btMvc;
    @BindView(R.id.bt_mvp)
    Button btMvp;
    @BindView(R.id.bt_mvvm)
    Button btMvvm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_mvc, R.id.bt_mvp, R.id.bt_mvvm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_mvc:
                startActivity(new Intent(this, MVCActivity.class));
                break;
            case R.id.bt_mvp:
                break;
            case R.id.bt_mvvm:
                break;
        }
    }
}
