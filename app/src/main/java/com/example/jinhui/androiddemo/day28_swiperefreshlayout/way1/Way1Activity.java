package com.example.jinhui.androiddemo.day28_swiperefreshlayout.way1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/4/10.
 * Email:1004260403@qq.com
 * <p>
 * 自定义 SwipeRefreshLayout + ListView
 */
public class Way1Activity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    private List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way1);
        ButterKnife.bind(this);

        for (int i = 0; i < 20; i++) {
            datas.add("item - " + i);
        }

        // 适配器
        final BaseAdapter baseAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, datas);

        listview.setAdapter(baseAdapter);

        // 自定义RefreshLayout实例
        final RefreshLayout refreshLayout = findViewById(R.id.swipe_layout);

        // 设置下拉刷新时的颜色值,颜色值需要定义在xml中
        // 默认SwipeRefreshLayout为黑色一种颜色

        refreshLayout.setColorScheme(R.color.umeng_comm_text_topic_light_color,
                R.color.umeng_comm_yellow, R.color.umeng_comm_green,
                R.color.umeng_comm_linked_text);

        // 设置下拉刷新监听器
       refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               Toast.makeText(Way1Activity.this, "refresh", Toast.LENGTH_SHORT).show();
               refreshLayout.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       // 更新数据
                       datas.add(new Date().toGMTString());
                       baseAdapter.notifyDataSetChanged();
                       // 更新完后调用该方法结束刷新
                       refreshLayout.setRefreshing(false);
                   }
               }, 1000);

           }
       });

       refreshLayout.setOnLoadMoreListener(new RefreshLayout.OnLoadMoreListener() {
           @Override
           public void onLoadMore() {
               Toast.makeText(Way1Activity.this, "load", Toast.LENGTH_SHORT).show();
               refreshLayout.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       datas.add(new Date().toGMTString());
                       baseAdapter.notifyDataSetChanged();
                       refreshLayout.setLoading(false);
                   }
               }, 1000);
           }
       });



    }
}
