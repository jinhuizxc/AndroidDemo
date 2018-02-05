package com.example.jinhui.androiddemo.day23.fragment02;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day23.MyFragment01;
import com.example.jinhui.androiddemo.day23.MyFragment02;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class Fragment02Activity extends AppCompatActivity {

    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.bt_hide)
    Button btHide;

    MyFragment01 myFragment01;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment02);
        ButterKnife.bind(this);

        // 创建一个碎片对象
        myFragment01 = new MyFragment01();
        MyFragment02 myFragment02 = new MyFragment02();
        // 获取碎片管理对象。功能添加，删除，替换， 隐藏，显示碎片等操作
        FragmentManager fragmentManager = this.getFragmentManager();
        // 开始碎片事物
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 添加碎片
        transaction.add(R.id.ll, myFragment01);
        transaction.add(R.id.ll, myFragment02);
        // 提交碎片事物
        transaction.commit();

    }

    @OnClick(R.id.bt_hide)
    public void onViewClicked() {
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        // 隐藏碎片
        transaction.hide(myFragment01);
        transaction.commit();
    }
}
