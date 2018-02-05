package com.example.jinhui.androiddemo.day22.listviewheader;

import android.content.Context;
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
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class Header extends RelativeLayout{

    RelativeLayout.LayoutParams params;
    View header;
    TextView tv;
    ImageView iv;
    ProgressBar pb;

    //顺时针旋转180度动画
    Animation ani;

    //正常状态（header的高为0的状态）
    public static final int NORMAL = 0x00;
    //下拉刷新
    public static final int DOWN = 0x01;
    //松开刷新
    public static final int UP = 0x02;
    //正在刷新
    public static final int UPDATE = 0x03;

    //当前状态
    private int currentStatus;

    public Header(Context context) {
        super(context);
        // 解析布局
        header = LayoutInflater.from(context).inflate(R.layout.listview_header, null);
        tv = (TextView) header.findViewById(R.id.textView1);
        iv = (ImageView) header.findViewById(R.id.imageView1);
        pb = (ProgressBar) header.findViewById(R.id.progressBar1);


        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 0);

        //params属性设置到header对象上
        this.addView(header, params);
//		this.addView(header);

        ani = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ani.setDuration(1000);
        ani.setFillAfter(true);
        iv.setAnimation(ani);
    }

    /**
     * 设置状态
     * @param statues
     */
    public void setStatus(int statues) {
        currentStatus = statues;
        switch (currentStatus) {
            case NORMAL:
                setHeaderHeight(0);
                break;
            case DOWN:
                tv.setText("下拉刷新");
                iv.clearAnimation();
                iv.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
                break;
            case UP:
                tv.setText("松开刷新");
                iv.clearAnimation();
                iv.setAnimation(ani);
                //播放动画
                ani.start();
                break;
            case UPDATE:
                tv.setText("正在刷新");
                iv.clearAnimation();
                iv.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);
                setHeaderHeight(40);
                break;
        }
    }

    public int getCurrentStatus() {
        return currentStatus;
    }

    /**
     * 设置header高度
     * @param i
     */
    public void setHeaderHeight(int i) {
        params.height = i;
        //重新设置header的高
        header.setLayoutParams(params);
    }

    public int getHeaderHeight() {
        return header.getLayoutParams().height;
    }
}
