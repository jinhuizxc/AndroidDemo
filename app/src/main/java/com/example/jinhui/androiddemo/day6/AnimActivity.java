package com.example.jinhui.androiddemo.day6;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day6.frameanim.CatActivity;
import com.example.jinhui.androiddemo.day6.frameanim.FrameAnimationActivity;
import com.example.jinhui.androiddemo.day6.propertyanim.PropertyAnimationActivity;
import com.example.jinhui.androiddemo.day6.tweenanim.TweenAnimationActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 *
 * Administrator
 * 总结：
 * 动画 1.TweenAnimation (Alpha, Rotation, Translation,Scale)
 *
 * 2.FrameAnimation
 *
 * 3.PropertyAnimation
 * (sdk3.0之后提出的，把它看成是TweenAnimation的增强版) ObjectAnimator, ValueAnimator
 * 4.动画的监听
 */

public class AnimActivity extends AppCompatActivity {

    @BindView(R.id.bt_tweenAnimation)
    Button btTweenAnimation;
    @BindView(R.id.bt_frameAnimation)
    Button btFrameAnimation;
    @BindView(R.id.bt_propertyAnimation)
    Button btPropertyAnimation;
    @BindView(R.id.bt_cat)
    Button btCat;
    @BindView(R.id.bt_1to3)
    Button bt1to3;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    // 一个按钮产生3个按钮：
    ArrayList<Button> listBtns = new ArrayList<Button>();
    int btnIds[] = { R.id.bt_1to3, R.id.button2, R.id.button3, R.id.button4 };
    boolean isClose = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.bind(this);
        // 得到线程名为 main
        Log.d("Tag", "activity running in = " + Thread.currentThread().getName());  // D/Tag: activity running in main

//        for (int i = 0; i < btnIds.length; i++) {
//            Button btn = (Button) findViewById(btnIds[i]);
//            btn.setOnClickListener(this);
//            listBtns.add(btn);
//        }
        for (int btnId : btnIds) {
            Button btn = (Button) findViewById(btnId);
            listBtns.add(btn);
        }

    }

    @OnClick({R.id.bt_tweenAnimation, R.id.bt_frameAnimation, R.id.bt_cat,
            R.id.bt_propertyAnimation, R.id.bt_1to3, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_tweenAnimation:
                startActivity(new Intent(this, TweenAnimationActivity.class));
                break;
            case R.id.bt_frameAnimation:
                startActivity(new Intent(this, FrameAnimationActivity.class));
                break;
            case R.id.bt_cat:
                startActivity(new Intent(this, CatActivity.class));
                break;
            case R.id.bt_propertyAnimation:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
            case R.id.bt_1to3:
                if (isClose) {
                    openBtns();
                } else {
                    closeBtns();
                }
                break;
            case R.id.button2:
                Toast.makeText(this, "商城", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(this, "朋友", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void closeBtns() {
        for (int i = 1; i < listBtns.size(); i++) {
            ObjectAnimator ani = ObjectAnimator.ofFloat(listBtns.get(i),
                    "translationY", -100 * i, 0);
            ani.setDuration(500);
            ani.setStartDelay((i - 1) * 100);
            ani.start();
        }
        isClose = true;
    }

    private void openBtns() {
        for (int i = 1; i < listBtns.size(); i++) {
            ObjectAnimator ani = ObjectAnimator.ofFloat(listBtns.get(i),
                    "translationY", 0, -100 * i);
            ani.setDuration(500);
            ani.setStartDelay((i - 1) * 100);
            ani.start();
        }
        isClose = false;
    }

}
