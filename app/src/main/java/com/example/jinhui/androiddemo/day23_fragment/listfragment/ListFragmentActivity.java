package com.example.jinhui.androiddemo.day23_fragment.listfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 *
 * 演示listfragment的使用
 * 1.listfragment的布局， listview的id固定，@id/android：list
 * 2.绑定数据 setlistadapter 绑定每项点击事件onListItemClick
 */
public class ListFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list1);
    }
}
