package com.example.jinhui.androiddemo.day21_adapter_footer_header.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class ExampleActivity extends AppCompatActivity {

    @BindView(R.id.bt_listview)
    Button btListview;
    @BindView(R.id.bt_scrollview)
    Button btScrollview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_listview, R.id.bt_scrollview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_listview:
                XListViewActivity.launch(this);
                break;
            case R.id.bt_scrollview:
                XScrollViewActivity.launch(this);
                break;
        }
    }
}
