package com.example.jinhui.androiddemo.day25.mvc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class MVCActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv_view)
    TextView tvView;

    // 引入model
    private MainModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        ButterKnife.bind(this);

        model = new MainModel();
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        loadData();
    }

    private void loadData() {
        model.loadData(tvView);
    }
}
