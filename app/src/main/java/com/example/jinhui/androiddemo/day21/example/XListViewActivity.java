package com.example.jinhui.androiddemo.day21.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day21.example.widget.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class XListViewActivity extends AppCompatActivity implements XListView.IXListViewListener {

    private static final String TAG = "XListViewActivity";
    @BindView(R.id.xlistview)
    XListView xlistview;

    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> items = new ArrayList<String>();
    private Handler mHandler;
    private int mIndex = 0;
    private int mRefreshIndex = 0;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, XListViewActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlistview);
        ButterKnife.bind(this);

        getItems();
        initView();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        // E/XListViewActivity: onWindowFocusChanged方法
        Log.e(TAG, "onWindowFocusChanged方法");
        if (hasFocus){
            xlistview.autoRefresh();
        }
    }

    private void initView() {
        mHandler = new Handler();

        xlistview.setPullRefreshEnable(true);
        xlistview.setPullLoadEnable(true);
        xlistview.setAutoLoadEnable(true);
        xlistview.setXListViewListener(this);
        xlistview.setRefreshTime(getTime());

        mAdapter = new ArrayAdapter<String>(this, R.layout.xlistview_item, items);
        xlistview.setAdapter(mAdapter);
    }

    private void getItems() {
        for (int i = 0; i != 20; ++i) {
            items.add("Test XListView item " + (++mIndex));
        }
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIndex = ++mRefreshIndex;
                items.clear();
                getItems();
                mAdapter = new ArrayAdapter<String>(XListViewActivity.this, R.layout.xlistview_item,
                        items);
                xlistview.setAdapter(mAdapter);
                // 停止加载
                onStopLoad();
            }
        }, 2500);
    }

    private void onStopLoad() {
        xlistview.stopRefresh();
        xlistview.stopLoadMore();
        xlistview.setRefreshTime(getTime());
    }

    private String getTime() {
        return new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA).format(new Date());
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getItems();
                mAdapter.notifyDataSetChanged();
                onStopLoad();
            }
        }, 2500);
    }
}
