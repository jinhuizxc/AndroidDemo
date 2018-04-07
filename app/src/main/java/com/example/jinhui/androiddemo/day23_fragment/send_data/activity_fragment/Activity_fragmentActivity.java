package com.example.jinhui.androiddemo.day23_fragment.send_data.activity_fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class Activity_fragmentActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.fl)
    FrameLayout fl;

    FragmentA fragmentA;
    FragmentTransaction trans;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_fragment);
        ButterKnife.bind(this);

        fragmentA = new FragmentA();
        //将碎片添加到Activity中
        trans = getFragmentManager().beginTransaction();
        trans.add(R.id.fl, fragmentA);
        trans.commit();
    }

    /**
     * 点击按钮进行传值
     */
    @OnClick(R.id.button1)
    public void onViewClicked() {
        // 方式一：
//        String name = editText.getText().toString();
//        fragmentA.setName(name);
        // 方式二：
        String name = editText.getText().toString().trim(); // 去除空格
        fragmentA = new FragmentA();
        // 创建bundle对象，传值
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        fragmentA.setArguments(bundle);

        trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.fl, fragmentA);
        trans.commit();

    }
}
