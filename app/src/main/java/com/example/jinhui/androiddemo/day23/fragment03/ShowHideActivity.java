package com.example.jinhui.androiddemo.day23.fragment03;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

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

public class ShowHideActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.fl)
    FrameLayout fl;

    Fragment fragment01;
    Fragment fragment02;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhide);
        ButterKnife.bind(this);

        fragment01 = new MyFragment01();
        fragment02 = new MyFragment02();

        FragmentTransaction tran = this.getFragmentManager().beginTransaction();

        tran.add(R.id.fl, fragment01);
        tran.add(R.id.fl, fragment02);
        tran.hide(fragment01);
        tran.hide(fragment02);

        tran.commit();
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        FragmentTransaction tran;
        switch (view.getId()) {
            case R.id.button1:
                tran = this.getFragmentManager().beginTransaction();
                tran.show(fragment01);
                tran.hide(fragment02);

                tran.commit();
                break;
            case R.id.button2:
                tran = this.getFragmentManager().beginTransaction();
                tran.show(fragment02);
                tran.hide(fragment01);
                tran.commit();
                break;
        }
    }
}
