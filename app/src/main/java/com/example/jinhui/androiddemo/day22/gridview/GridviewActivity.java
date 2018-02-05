package com.example.jinhui.androiddemo.day22.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class GridviewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.gridView)
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        ButterKnife.bind(this);

        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            data.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.gridview_item, data);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "position = " + position, Toast.LENGTH_SHORT).show();
        if(position == 4){
            Toast.makeText(this, "开始抽奖", Toast.LENGTH_SHORT).show();
        }
    }
}
