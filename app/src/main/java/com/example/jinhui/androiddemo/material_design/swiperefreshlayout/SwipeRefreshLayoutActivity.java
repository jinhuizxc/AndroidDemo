package com.example.jinhui.androiddemo.material_design.swiperefreshlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.material_design.swiperefreshlayout.way1.Way1Activity;
import com.example.jinhui.androiddemo.material_design.swiperefreshlayout.way2.Way2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/4/10.
 * Email:1004260403@qq.com
 * <p>
 * 整理以前自己的学习下拉刷新的部分，将这部分继续强化
 */
public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefresh);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, Way1Activity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, Way2Activity.class));
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
        }
    }
}
