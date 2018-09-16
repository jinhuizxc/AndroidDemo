package com.example.jinhui.androiddemo.ui.banner.viewpagerbanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jh on 2018/9/2.
 * Email: 1004260403@qq.com
 * <p>
 * viewpager 轮播
 */
public class ViewPagerActivity extends AppCompatActivity {

    protected static final String tag = "ViewPagerActivity";

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.ll_dots)
    LinearLayout llDots;
    @BindView(R.id.tv_ratio)
    TextView tvRatio;

    private TextView tv_dot;

    private List<ImageView> imageList = new ArrayList<ImageView>();
    private List<TextView> tv_dots_list = new ArrayList<TextView>();
    private Context context;
    int msgWhat = 0;
    private String[] des_arrays;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);// 收到消息，指向下一个页面
            handler.sendEmptyMessageDelayed(msgWhat, 5000);// 5s后在发送一条消息，由于在handleMessage()方法中，造成死循环。
            Log.d(tag, "handleMessage");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);

        context = this;
        initViewPagerData();// 初始化viewpager中存放的数据
        initDesData();// 图片描述数据

        viewpager.setAdapter(new MyAdapter());

        viewpager.setCurrentItem(imageList.size() * 1000); // 设置当前页是5000页,也即是0页：因为5000%5=0.
        // 初始化指示器
        initIndicator();//监听pager的变化

        // 默认从第1个开始。
        tvDesc.setText(des_arrays[0]);
        tvRatio.setText("1/5");
        tv_dots_list.get(0).setSelected(true);

    }

    private void initIndicator() {
        initDots();// 初始化圆点

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                tvDesc.setText(des_arrays[position % imageList.size()]);
                tvRatio.setText(1 + position % imageList.size() + "/" + imageList.size());
                for (int i = 0; i < tv_dots_list.size(); i++) {
                    if (i == position % imageList.size()) {
                        tv_dots_list.get(i).setSelected(true);
                    } else {
                        tv_dots_list.get(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    /**
     * // 初始化圆点
     */
    private void initDots() {
        llDots.removeAllViews();
        tv_dots_list.clear();
        // layout子view的属性
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
        params.setMargins(0, 0, 10, 0);
        for (int i = 0; i < imageList.size(); i++) {
            tv_dot = new TextView(context);
            tv_dot.setBackgroundResource(R.drawable.tv_dot_selector);
            llDots.addView(tv_dot, params);
            tv_dots_list.add(tv_dot);
        }

    }

    /**
     * activity可见可交互的时候就开始发送消息，开启循环
     */
    @Override
    protected void onResume() {
        super.onResume();
        handler.sendEmptyMessageDelayed(msgWhat, 5000);
    }

    /**
     * 当MainActivity不可见的时候让handler停止发送消息 防止内存泄露
     */
    @Override
    protected void onStop() {
        super.onStop();
        handler.removeMessages(msgWhat);
    }

    private void initDesData() {
        des_arrays = getResources().getStringArray(R.array.des_array);
    }

    private void initViewPagerData() {
        imageList.clear();

        ImageView iva = new ImageView(context);
        iva.setBackgroundResource(R.drawable.a);

        ImageView ivb = new ImageView(context);
        ivb.setBackgroundResource(R.drawable.b);

        ImageView ivc = new ImageView(context);
        ivc.setBackgroundResource(R.drawable.c);

        ImageView ivd = new ImageView(context);
        ivd.setBackgroundResource(R.drawable.d);

        ImageView ive = new ImageView(context);
        ive.setBackgroundResource(R.drawable.e);

        imageList.add(iva);
        imageList.add(ivb);
        imageList.add(ivc);
        imageList.add(ivd);
        imageList.add(ive);
    }


    private class MyAdapter extends PagerAdapter {

        // 表示viewpager共存放了多少个页面
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;// 我们设置viewpager中有Integer.MAX_VALUE个页面
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * position % imageList.size() 而不是position，是为了防止角标越界异常
         * 因为我们设置了viewpager子页面的数量有Integer.MAX_VALUE，而imageList的数量只是5。
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageList.get(position % imageList.size()));
            return imageList.get(position % imageList.size());
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);  // 注释掉,否则滑动时会闪退！
            container.removeView((View) object);
        }
    }
}
