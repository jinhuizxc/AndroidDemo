package com.example.jinhui.androiddemo.day23_fragment.stack.stack3;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * 能不能fragment里面嵌套framment的功能模块？
 */

public class Stack3Activity extends AppCompatActivity implements Stack3Fragment.MyListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack2);

        //添加Fragment01
        Stack3Fragment stackFragment1 = new Stack3Fragment();
        FragmentTransaction tran = this.getFragmentManager().beginTransaction();
        tran.add(R.id.rr, stackFragment1);
        tran.commit();
        // 设置监听
        stackFragment1.setListener(this);
    }

    @Override
    public void update() {
        //替换碎片
        FragmentTransaction tran = this.getFragmentManager().beginTransaction();
        tran.replace(R.id.rr, new Stack31Fragment());
        tran.addToBackStack(null);
        tran.commit();
    }
}
