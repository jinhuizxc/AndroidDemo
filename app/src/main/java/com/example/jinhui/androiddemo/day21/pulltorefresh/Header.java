package com.example.jinhui.androiddemo.day21.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class Header extends RelativeLayout {

    RelativeLayout rl;
    /**
     * 布局的属性对象（宽高）
     */
    LayoutParams rp;

    TextView tv;
    ImageView iv;
    ProgressBar pb;

    /**
     * 下拉刷新
     */
    public final static int DOWN = 0X01;
    /**
     * 松开刷新
     */
    public final static int UP = 0X02;
    /**
     * 正在刷新
     */
    public final static int UPDATE = 0X03;
    /**
     * 当前状态
     */
    private int current;
    /**
     * 上一次状态
     */
    private int last;

    Animation am_up, am_down;

    public Header(Context context) {
        super(context);

        rl = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.header, null);

        tv = (TextView) rl.findViewById(R.id.textView1);
        iv = (ImageView) rl.findViewById(R.id.imageView1);
        pb = (ProgressBar) rl.findViewById(R.id.progressBar1);

        //创建相对布局的宽高属性对象
        rp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0);
        //将相对布局添加到Header首部中
        this.addView(rl, rp);

        am_up = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //设置动画播放的时间(毫秒)
        am_up.setDuration(1000);
        am_up.setFillAfter(true);

        am_down = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        am_down.setDuration(1000);
        am_down.setFillAfter(true);
    }

    public Header(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Header(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 设定当前首部的状态
     */
    public void setStatus(int status) {
        current = status;
        switch (status) {
            case DOWN:
                tv.setText("下拉刷新");
                iv.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
                if (last != current && last == UP) {
                    iv.clearAnimation();
                    iv.startAnimation(am_down);
                }
                break;
            case UP:
                tv.setText("松开刷新");
                iv.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
                if (last != current) {
                    iv.clearAnimation();
                    iv.startAnimation(am_up);
                }
                break;
            case UPDATE:
                tv.setText("正在刷新");
                iv.clearAnimation();
                iv.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);
                break;
        }
        last = current;
    }

    /**
     * 设定header首部的高
     */
    public void setHeaderHeight(int add) {
        rp.height = add;
        rl.setLayoutParams(rp);
    }

    /**
     * 获取header首部的高
     */
    public int getHeaderHeight() {
        return rl.getLayoutParams().height;
    }

    public int getCurrent() {
        return current;
    }
}
