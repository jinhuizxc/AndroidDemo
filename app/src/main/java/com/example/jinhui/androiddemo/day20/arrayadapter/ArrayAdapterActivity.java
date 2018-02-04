package com.example.jinhui.androiddemo.day20.arrayadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class ArrayAdapterActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrayadapter);
        ButterKnife.bind(this);

        //数据模型
        String words[] = new String[26];
        for (int i = 0; i < words.length; i++) {
            words[i] = (char) ('a' + i) + ":" + ('a' + i); //自动装箱
        }

        //数组适配器 （数据模型，视图布局）
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, words);
        //绑定适配器
        listview.setAdapter(adapter);
    }
}
