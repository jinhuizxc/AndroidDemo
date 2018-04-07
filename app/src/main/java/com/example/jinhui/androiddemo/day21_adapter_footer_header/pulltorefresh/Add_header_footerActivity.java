package com.example.jinhui.androiddemo.day21_adapter_footer_header.pulltorefresh;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class Add_header_footerActivity extends AppCompatActivity implements OnRefreshHeader, OnRefreshFooter {

    List<String> values = new ArrayList<String>();
    int count = 0;
    ArrayAdapter<String> adapter;

    @BindView(R.id.mylist)
    MyListView mylist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addheaderfooter);
        ButterKnife.bind(this);


        for (int i = 0; i < 5; i++) {
            values.add(String.valueOf(i));
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);

        mylist.setAdapter(adapter);
        mylist.setOnReFreshHeader(this);
        mylist.setOnReFreshFooter(this);
    }

    @Override
    public void onRefreshHead() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (this) {
                    handler.sendEmptyMessage(1);
                }
            }
        }).start();
    }

    @Override
    public void onRefreshFoot() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    handler.sendEmptyMessage(2);
                }
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                values.add(0, String.valueOf(--count));
                adapter.notifyDataSetChanged();
                mylist.setOnReFreshFinish();
            } else if (msg.what == 2) {
                for (int i = 0; i < 5; i++)
                    values.add(String.valueOf(i));
                adapter.notifyDataSetChanged();
                mylist.setOnReFreshFooterFinish();
            }
        }
    };
}
