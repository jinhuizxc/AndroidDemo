package com.example.jinhui.androiddemo.recyclerview.recyclerviewbanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.widget.BannerIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jh on 2018/8/31.
 * Email: 1004260403@qq.com
 *
 * 代码1: https://github.com/LGD2009/recyclerbanner
 * 代码2: https://github.com/loonggg/RecyclerViewBanner
 *
 * 面试总结（6）：ScheduledExecutorService的使用
 * https://blog.csdn.net/u011315960/article/details/71422386
 */
public class RVBannerActivity extends AppCompatActivity {

    private List<Integer> list = new ArrayList<>(4);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvbanner);

        list.add(R.drawable.b1);
        list.add(R.drawable.b2);
        list.add(R.drawable.b3);
        list.add(R.drawable.b4);

        BannerAdapter adapter = new BannerAdapter(this, list);
        final RecyclerView recyclerView = findViewById(R.id.recycler);
        final SmoothLinearLayoutManager layoutManager = new SmoothLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(list.size() * 10);

        // RecyclerView特性
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        // 指示器
        final BannerIndicator bannerIndicator = findViewById(R.id.indicator);
        bannerIndicator.setNumber(list.size());

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int i = layoutManager.findFirstVisibleItemPosition() % list.size();
                    bannerIndicator.setPosition(i);
                }
            }
        });

        // 定时任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition() + 1);
            }
        }, 2000, 2000, TimeUnit.MILLISECONDS);

    }
}
