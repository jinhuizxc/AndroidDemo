package com.example.jinhui.androiddemo.day5.finishall.finishall2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day5.finishall.Tool;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */

public class Third1Activity extends BaseActivity {

    @BindView(R.id.bt_back)
    Button btBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_back)
    public void onViewClicked() {
        for (int i = 0; i < Tool.list.size(); i++) {
            Tool.list.get(i).finish();
        }
    }
}
