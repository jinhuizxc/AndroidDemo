package com.example.jinhui.androiddemo.day6.propertyanim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 * <p>
 * 属性动画(PropertyAnimation)
 * andorid3.0引入。属性动画改变对象的一个field值实现动画。指定你想要的属性，多长时间，动画的值就可以实现了。
 * <p>
 * Animation有局限性（个人认为是因为动画的局限性引入属性动画）
 */

public class PropertyAnimationActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.bt01)
    Button bt01;
    @BindView(R.id.bt02)
    Button bt02;
    @BindView(R.id.bt03)
    Button bt03;
    @BindView(R.id.bt04)
    Button bt04;
    @BindView(R.id.bt05)
    Button bt05;
    @BindView(R.id.bt_listener)
    Button btListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertyanim);
        ButterKnife.bind(this);
    }

    public void clickText(View view) {
        Toast.makeText(this, "点击textView", Toast.LENGTH_SHORT).show();
    }

    public void clickBtn(View view) {

//		1.1(一个属性动画的实现)
//		Animation ani = new TranslateAnimation(0, 0, 0, 100);
//		ani.setDuration(2000);
//		ani.setFillAfter(true); //动画播放后停留在最后一帧
//		tv.startAnimation(ani);

//		1.2属性动画	给文本框添加平移动画
//		ObjectAnimator ani = ObjectAnimator.ofFloat(tv, "translationY", 0, 100, 0);
//		ani.setDuration(2000);
//		ani.start();

//		属性名：rotation，alpha,scaleX, scaleY, tranlationX, translationY
//		1.3给按钮添加闪烁动画
        ObjectAnimator aniBtn = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0, 1.0f);
        aniBtn.setDuration(500);
        aniBtn.start();

//		2.同时播放三个动画((多个属性动画实现01))
//		PropertyValuesHolder p01 = PropertyValuesHolder.ofFloat("translationX", 0, 100);
//		PropertyValuesHolder p02 = PropertyValuesHolder.ofFloat("translationY", 0, 100);
//		PropertyValuesHolder p03 = PropertyValuesHolder.ofFloat("rotation", 0, 360);
//
//		ObjectAnimator aniSet = ObjectAnimator.ofPropertyValuesHolder(tv, p01, p02, p03);
//		aniSet.setDuration(2000);
//		aniSet.start();

////		3.按照指定顺序播放动画(多个属性动画实现02)
//		ObjectAnimator ani01 = ObjectAnimator.ofFloat(tv, "translationX", 0, 100);
//		ObjectAnimator ani02 = ObjectAnimator.ofFloat(tv, "translationY", 0, 100);
//		ObjectAnimator ani03 = ObjectAnimator.ofFloat(tv, "rotation", 0, 360);
//		//组合动画
//		AnimatorSet set = new AnimatorSet();
//		//按照指定顺序播放
////		set.playSequentially(ani01, ani02, ani03);
//
//		set.play(ani01).with(ani02);
//		set.play(ani03).after(ani01);
//		//设置播放时间
//		set.setDuration(5000);
//		set.start();

    }

    @OnClick({R.id.bt01, R.id.bt02, R.id.bt03, R.id.bt04, 
            R.id.bt05, R.id.bt_listener})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt01:
                doBt01(view);
                break;
            case R.id.bt02:
                doBt02(view);
                break;
            case R.id.bt03:
                doBt03(view);
                break;
            case R.id.bt04:
                doBt04(view);
                break;
            case R.id.bt05:
                doBt05(view);
                break;
            case R.id.bt_listener:
                doListener();
                break;
        }
    }

    /**
     * 动画监听事件
     * 透明度属性动画
     ObjectAnimator animator = ObjectAnimator.ofFloat(v, "alpha", 0, 1);
     animator.setDuration(1000);
     //添加属性动画的监听
     animator.addListener(new AnimatorListener() {

    @Override
    public void onAnimationStart(Animator animation) {
    // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationRepeat(Animator animation) {
    // TODO Auto-generated method stub

    }

    //动画结束之后调用该方法
    @Override
    public void onAnimationEnd(Animator animation) {
    // TODO Auto-generated method stub
    Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationCancel(Animator animation) {
    // TODO Auto-generated method stub

    }
    });

     animator.start();
     */
    private void doListener() {
        ValueAnimator valueAni = ValueAnimator.ofInt(0, 255);
        valueAni.setDuration(1000);
        valueAni.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                Log.d("Test", "updata value = " + animation.getAnimatedValue());

                textView1.setTextColor(Color.rgb((Integer)animation.getAnimatedValue(), 0, 0));
            }
        });

        //播放动画
        valueAni.start();
    }

    /**
     * ObjectAnimator oa01 = ObjectAnimator.ofFloat(iv, "translationX", 0, 50);
     * ObjectAnimator oa02 = ObjectAnimator.ofFloat(iv, "translationY", 0, 50);
     * ObjectAnimator oa03 = ObjectAnimator.ofFloat(iv, "rotation", 0, 360);
     * <p>
     * AnimatorSet set = new AnimatorSet();
     * //同时播放
     * //set.playTogether(oa01, oa02, oa03);
     * //按顺序播放（先播01，再播02，最后播03）
     * //set.playSequentially(oa01, oa02, oa03);
     * //按指定顺序播放 （01和02同时播放，最后播放03）
     * set.play(oa01).with(oa02);
     * set.play(oa03).after(oa01);
     * <p>
     * set.setDuration(1000);
     * set.start();
     *
     * @param view
     */
    private void doBt05(View view) {
        // 3.按照指定顺序播放动画(多个属性动画实现02)
        ObjectAnimator ani01 = ObjectAnimator.ofFloat(textView1, "translationX", 0, 100);
        ObjectAnimator ani02 = ObjectAnimator.ofFloat(textView1, "translationY", 0, 100);
        ObjectAnimator ani03 = ObjectAnimator.ofFloat(textView1, "rotation", 0, 360);
        //组合动画
        AnimatorSet set = new AnimatorSet();
        //按照指定顺序播放
//		set.playSequentially(ani01, ani02, ani03);

        set.play(ani01).with(ani02);
        set.play(ani03).after(ani01);
        //设置播放时间
        set.setDuration(5000);
        set.start();
    }

    /**
     * PropertyValuesHolder p01 = PropertyValuesHolder.ofFloat("translationX", 0, 100);
     * PropertyValuesHolder p02 = PropertyValuesHolder.ofFloat("translationY", 0, 100);
     * PropertyValuesHolder p03 = PropertyValuesHolder.ofFloat("rotation", 0, 360);
     * ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv, p01, p02, p03);
     * animator.setDuration(2000);
     * animator.start();
     *
     * @param view
     */
    private void doBt04(View view) {
        // 2.同时播放三个动画((多个属性动画实现01))
        PropertyValuesHolder p01 = PropertyValuesHolder.ofFloat("translationX", 0, 100);
        PropertyValuesHolder p02 = PropertyValuesHolder.ofFloat("translationY", 0, 100);
        PropertyValuesHolder p03 = PropertyValuesHolder.ofFloat("rotation", 0, 360);

        ObjectAnimator aniSet = ObjectAnimator.ofPropertyValuesHolder(textView1, p01, p02, p03);
        aniSet.setDuration(2000);
        aniSet.start();
    }

    private void doBt03(View view) {
        // 1.3给按钮添加闪烁动画
        ObjectAnimator aniBtn = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0, 1.0f);
        aniBtn.setDuration(500);
        aniBtn.start();
    }

    /**
     * //参数：
     * //动画作用目标
     * //属性
     * //属性值
     * ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "translationX", 0, 100);
     * animator.setDuration(2000);
     * animator.start();
     * <p>
     * Animation动画框架仅仅只是让图像发生位移，而监听事件依然在原地。
     * 而属性动画可以移动让监听事件也跟着移动。
     *
     * @param view
     */
    private void doBt02(View view) {
        // 1.2给文本框添加平移动画
        ObjectAnimator ani = ObjectAnimator.ofFloat(textView1, "translationY", 0, 100, 0);
        ani.setDuration(2000);
        ani.start();
    }


    private void doBt01(View view) {
        // 1.1(一个属性动画的实现)
        Animation ani = new TranslateAnimation(0, 0, 0, 100);
        ani.setDuration(2000);
//		ani.setFillAfter(true); //动画播放后停留在最后一帧
        ani.setFillAfter(false);
        textView1.startAnimation(ani);

    }
}
