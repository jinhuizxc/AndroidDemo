package com.example.jinhui.androiddemo.day6.frameanim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */

public class FrameAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_play;
    @BindView(R.id.bt_java)
    Button btJava;
    @BindView(R.id.bt_play)
    Button btPlay;
    @BindView(R.id.imageView)
    ImageView imageView;

    AnimationDrawable aniDrawable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameanim);
        ButterKnife.bind(this);
        //设置帧动画，解析帧动画文件，生成AnimationDrawable对象
        imageView = findViewById(R.id.imageView);
        bt_play = findViewById(R.id.bt_play);
        bt_play.setOnClickListener(this);
        imageView.setImageResource(R.drawable.ani_dragon_down);
        //创建动画对象, 这里需要注意一点，关于为什么不能像上面控制动画的播放与暂停？原因在于每次都new AnimationDrawable(),将此方法写在前面只生成一次对象就好！
        aniDrawable = new AnimationDrawable();
    }


    // 参数 v 指向用户点击的控件对象
    @Override
    public void onClick(View v) {
        //获取帧动画对象
        AnimationDrawable aniFrame = (AnimationDrawable) imageView.getDrawable();
        Button btn = (Button) v;//父类型指向子类型,强转类型
        //设置帧动画属性
        //播放一次
        //aniFrame.setOneShot(true);
        //如果正在播放，停止
        if (aniFrame.isRunning()) {
            aniFrame.stop();
            btn.setText("播放");
        } else {
            aniFrame.start();
            btn.setText("停止");
        }
    }

    /**
     * //创建动画对象
     * AnimationDrawable aniDrawable = new AnimationDrawable();
     * //设置每一帧的帧图片，每一帧播放时间
     * aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.inc_btn_emphasize_normal), 100);
     * aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.inc_btn_emphasize_pressed), 100);
     * aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.inc_btn_normal), 100);
     * aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.inc_btn_pressed), 100);
     * <p>
     * imageView.setImageDrawable(aniDrawable);
     * <p>
     *
     */
    @OnClick(R.id.bt_java)
    public void onViewClicked() {
    }

    @OnClick({R.id.bt_java})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_java:
                //设置每一帧的帧图片，每一帧播放时间
                aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.dest_0_0), 100);
                aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.dest_0_1), 100);
                aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.dest_0_2), 100);
                aniDrawable.addFrame(this.getResources().getDrawable(R.drawable.dest_0_3), 100);
                imageView.setImageDrawable(aniDrawable);
                aniDrawable.setOneShot(false);
                if (aniDrawable.isRunning()){
                    aniDrawable.stop();
                    btJava.setText("java代码构建-播放");
                }else {
                    aniDrawable.start();
                    btJava.setText("停止");
                }
                break;
        }
    }
}
