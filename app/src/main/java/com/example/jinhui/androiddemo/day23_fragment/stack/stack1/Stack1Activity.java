package com.example.jinhui.androiddemo.day23_fragment.stack.stack1;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day23_fragment.MyFragment01;
import com.example.jinhui.androiddemo.day23_fragment.MyFragment02;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * Fragment后台栈管理

 事务回退
 对Fragment的增删都是通过事务的形式来完成的，事务可以被提交，也可以被回退。

 在提交事务前，如果调用FragmentTransaction的 addToBackStack方法，就可以将该事务添加到后台栈，之后可以通过返回键/popBackStack方法，回退该事务。
 */

public class Stack1Activity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.fl)
    FrameLayout fl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        FragmentTransaction tran;
        switch (view.getId()) {
            case R.id.button1:
                tran = this.getFragmentManager().beginTransaction();

                Fragment fragment01 = new MyFragment01();
                tran.add(R.id.fl, fragment01);

                //将当前碎片事务处理添加到回退栈
                tran.addToBackStack(null);

                tran.commit();
                break;
            case R.id.button2:
                tran = this.getFragmentManager().beginTransaction();
                Fragment fragment02 = new MyFragment02();
                tran.add(R.id.fl, fragment02);
                //将当前碎片事务处理添加到回退栈
                tran.addToBackStack(null);
                tran.commit();
                break;
        }
    }
}
