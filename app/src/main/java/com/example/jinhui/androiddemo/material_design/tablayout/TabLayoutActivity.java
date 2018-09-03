package com.example.jinhui.androiddemo.material_design.tablayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.material_design.tablayout.tab.TabActivity;
import com.example.jinhui.androiddemo.material_design.tablayout.tabvp.TabVpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jh on 2018/9/2.
 * Email: 1004260403@qq.com
 * <p>
 * 各种样式Tab: https://github.com/H07000223/FlycoTabLayout
 * <p>
 * tablelayout 基本使用:
 * https://m.jb51.net/show/120336
 */
public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.bt_tablayout)
    Button btTablayout;
    @BindView(R.id.bt_tab_viewpager)
    Button btTabViewpager;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);

        context = this;
    }

    @OnClick({R.id.bt_tablayout, R.id.bt_tab_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_tablayout:
                startActivity(new Intent(context, TabActivity.class));
                break;
            case R.id.bt_tab_viewpager:
                // 配合ViewPager的使用方式
                startActivity(new Intent(context, TabVpActivity.class));
                break;
        }
    }
}
