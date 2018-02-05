package com.example.jinhui.androiddemo.day23.stack;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day23.MyFragment01;
import com.example.jinhui.androiddemo.day23.MyFragment02;
import com.example.jinhui.androiddemo.day23.stack.stack2.StackFragment1;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class Stack2Activity extends AppCompatActivity implements StackFragment1.UpdateDataToActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack2);

        //添加Fragment01
        StackFragment1 stackFragment1 = new StackFragment1();

        FragmentTransaction tran = this.getFragmentManager().beginTransaction();
        tran.add(R.id.rr, stackFragment1);
        tran.commit();
        // 设置监听
        stackFragment1.setUp(this);
    }

    @Override
    public void update() {
        //替换碎片
        FragmentTransaction tran = this.getFragmentManager().beginTransaction();
        tran.replace(R.id.rr, new MyFragment02());
        tran.addToBackStack(null);
        tran.commit();
    }
}
