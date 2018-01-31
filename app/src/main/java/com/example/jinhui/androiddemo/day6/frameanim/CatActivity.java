package com.example.jinhui.androiddemo.day6.frameanim;


import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/30.
 * Email:1004260403@qq.com
 * <p>
 * button设置透明
 * 可以在XML里：android:background="@android:color/transparent"
 * 或者在Java里：btn.setBackgroundColor(Color.TRANSPARENT);
 *
 * 目前动画效果出来了，但是无法stop,ok这个bug解决了！
 */

public class CatActivity extends AppCompatActivity {

    private static final String TAG = "CatActivity";
    @BindView(R.id.bt_nose)
    Button btNose;
    @BindView(R.id.bt_fart)
    Button btFart;
    @BindView(R.id.bt_eye)
    Button btEye;
    @BindView(R.id.bt_swipe_left)
    Button btSwipeLeft;
    @BindView(R.id.bt_poke_foot)
    Button btPokeFoot;

    AnimationDrawable animationDrawable;
    @BindView(R.id.rl)
    RelativeLayout rl;

    // 控制rl对象在点击按钮的时候只创建一次
    boolean isValue0;
    boolean isValue1;
    boolean isValue2;
    boolean isValue3;
    boolean isValue4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        ButterKnife.bind(this);
        // 初始化
        animationDrawable = (AnimationDrawable) rl.getBackground();
//        // 初始化
//        iv.setImageResource(R.drawable.breath_anim);
//        // 获取帧动画对象
//        animationDrawable = (AnimationDrawable) iv.getDrawable();
        init();
    }

    private void init() {



        rl.setBackground(getResources().getDrawable(R.drawable.poke_foot_anim));
    }


    @OnClick({R.id.bt_nose, R.id.bt_fart, R.id.bt_eye, R.id.bt_swipe_left, R.id.bt_poke_foot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_eye:
                if (!isValue0){
                    rl.setBackground(getResources().getDrawable(R.drawable.look_anim));
                    isValue0 = true;
                }
                animationDrawable = (AnimationDrawable) rl.getBackground();
                // y因为每次都要执行 rl.setBackground(getResources().getDrawable(R.drawable.look_anim));
                // 故每次都创建新的对象，就不能执行就stop
                //  animationDrawable =android.graphics.drawable.AnimationDrawable@f79849b
                // animationDrawable =android.graphics.drawable.AnimationDrawable@965c7e4
                Log.e(TAG, "animationDrawable =" + animationDrawable);
//                rl.setBackgroundResource(R.drawable.look_anim);
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }else {
                    animationDrawable.start();
                }
                break;
            case R.id.bt_nose:
                if (!isValue1){
                    rl.setBackground(getResources().getDrawable(R.drawable.breath_anim));
                    isValue1 = true;
                }
                animationDrawable = (AnimationDrawable) rl.getBackground();
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }else {
                    animationDrawable.start();
                }
                break;
            case R.id.bt_fart:
                if (!isValue2){
                    rl.setBackground(getResources().getDrawable(R.drawable.fart_anim));
                    isValue2 = true;
                }
                // 这样子用不起作用的
//                rl.setBackgroundResource(R.drawable.fart_anim);
                // 初始化
                animationDrawable = (AnimationDrawable) rl.getBackground();
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }else {
                    animationDrawable.start();
                }
                break;
            case R.id.bt_swipe_left:
                if (!isValue3){
                    rl.setBackground(getResources().getDrawable(R.drawable.swipe_left));
                    isValue3 = true;
                }
                animationDrawable = (AnimationDrawable) rl.getBackground();
//                rl.setBackgroundResource(R.drawable.swipe_left);
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }else {
                    animationDrawable.start();
                }
                break;
            case R.id.bt_poke_foot:
                if (!isValue4){
                    rl.setBackground(getResources().getDrawable(R.drawable.poke_foot_anim));
                    isValue4 = true;
                }
                animationDrawable = (AnimationDrawable) rl.getBackground();
//                rl.setBackgroundResource(R.drawable.poke_left_anim);
                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                }else {
                    animationDrawable.start();
                }
                break;
        }
    }
}
