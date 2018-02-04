package com.example.jinhui.androiddemo.day21.addfooter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class AddFooterActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> data;
    ArrayAdapter<Integer> adapter;
    int count;
    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfooter);
        ButterKnife.bind(this);

        data = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            count = i;
            data.add(i);
        }

        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, data);

        View view = LayoutInflater.from(this).inflate(R.layout.footer, null);
        //添加footer
        listView.addFooterView(view);

        listView.setAdapter(adapter);

        Button btn = (Button) view.findViewById(R.id.button1);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int max = count + 10;
        for (int i = count + 1; i < max; i++) {
            data.add(i);
            count = i;
        }
        adapter.notifyDataSetChanged();
    }
}
