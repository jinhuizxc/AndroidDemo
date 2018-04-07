package com.example.jinhui.androiddemo.day20_adapter.listviewlistener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class ListViewListenerActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener {

    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewlistener);
        ButterKnife.bind(this);

        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            data.add(i+1);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, data);


        listview.setAdapter(adapter);

        listview.setOnItemLongClickListener(this);
        listview.setOnItemClickListener(this);
        listview.setOnScrollListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("Test", "onItemLongClick");
        Toast.makeText(this, "position = " + position, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("Test", "onItemClick");
        Log.e("Test", "position" + position);
        Toast.makeText(this, "position = " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    // ListView在滑动过程中不断被调用
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

		Log.e("Test", "firstVisibleItem = " + firstVisibleItem);
		Log.e("Test", "visibleItemCount = " + visibleItemCount);
		Log.e("Test", "totalItemCount = " + totalItemCount);
    }
}
