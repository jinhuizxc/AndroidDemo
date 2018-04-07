package com.example.jinhui.androiddemo.day21_adapter_footer_header.addfooter;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day21_adapter_footer_header.addfooter.refresh.MyListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class AddFooter1Activity extends AppCompatActivity {


    @BindView(R.id.listView)
    MyListView listView;

    ArrayList<Integer> data;
    ArrayAdapter<Integer> adapter;

    int count;
    boolean isReFresh = false;
    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfooter1);
        ButterKnife.bind(this);

        data = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            data.add(i);
            count = i;
        }

        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        // setOnScrollListener监听
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            /**
             * 谨记这里的判定是2个：
             * firstVisibleItem + visibleItemCount == totalItemCount && !isReFresh
             *
             */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && !isReFresh) {
                    isReFresh = true;
                    Log.e("Test", "到底啦");
//                    Toast.makeText(AddFooter1Activity.this, "到底啦...", Toast.LENGTH_SHORT).show();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int max = count + 10;
                            for (int i = count + 1; i < max; i++) {
                                data.add(i);
                                count = i;
                            }
                            adapter.notifyDataSetChanged();
                            isReFresh = false;
                        }
                    }, 1000);

                }
            }
        });
    }
}
