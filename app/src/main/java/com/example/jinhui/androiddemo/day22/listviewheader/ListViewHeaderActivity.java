package com.example.jinhui.androiddemo.day22.listviewheader;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class ListViewHeaderActivity extends AppCompatActivity implements MyListView.MyReFreshListener {


    ArrayList<Integer> data;
    ArrayAdapter<Integer> adapter;
    @BindView(R.id.listview)
    MyListView listview;

    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewheader);
        ButterKnife.bind(this);

        data = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            data.add(i);
        }

        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, data);
        listview.setAdapter(adapter);

        // 设置用户自定义的监听
        listview.setRefreshListenner(this);
    }

    @Override
    public void onReFresh() {
        Toast.makeText(this, "刷新数据", Toast.LENGTH_SHORT).show();
        //三秒之后结束刷新
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                data.add(0, data.get(0)-1);
                adapter.notifyDataSetChanged();
                listview.finishRefresh();
            }
        }, 3000);
    }
}
