package com.example.jinhui.androiddemo.day23_fragment.fragmentanim;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * Fragment动画效果

 设置动画效果步骤
 为Fragment的进入和退出设置系统动画
 在FragmentTransaction被提交之前设置系统动画，setTransition(动画效果)
 FragmentTransaction.TRANSITFRAGMENTOPEN：打开效果
 FragmentTransaction.TRANSITFRAGMENTCLOSE：关闭效果
 */

public class Fragment_animActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.fl)
    FrameLayout fl;

    FragmentAnim fragmentAnim;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_anim);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        FragmentTransaction tran;
        switch (view.getId()) {
            case R.id.button1:
                tran = this.getFragmentManager().beginTransaction();

                fragmentAnim = new FragmentAnim();
                tran.add(R.id.fl, fragmentAnim);

                //设置动画
                tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                tran.commit();

                break;
            case R.id.button2:
                tran = this.getFragmentManager().beginTransaction();
                tran.remove(fragmentAnim);

                //设置动画
                tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                tran.commit();

                break;
        }
    }
}
