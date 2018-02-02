package com.example.jinhui.androiddemo.day12;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day12.surfaceview.SurfaceViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 * <p>
 * 高级界面04
 */

public class AdvanceInterface4Activity extends AppCompatActivity {

    @BindView(R.id.bt_linearlayout)
    Button btLinearlayout;
    @BindView(R.id.bt_surfaceView)
    Button btSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanceinterface4);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_linearlayout, R.id.bt_surfaceView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_linearlayout:
                startActivity(new Intent(this,CustomLinearlayoutActivity.class));
                break;
            case R.id.bt_surfaceView:
                startActivity(new Intent(this,SurfaceViewActivity.class));
                break;
        }
    }
}
