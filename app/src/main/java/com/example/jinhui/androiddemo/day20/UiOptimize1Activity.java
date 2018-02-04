package com.example.jinhui.androiddemo.day20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day20.arrayadapter.ArrayAdapterActivity;
import com.example.jinhui.androiddemo.day20.baseadapter.BaseAdapterActivity;
import com.example.jinhui.androiddemo.day20.contact.ContactActivity;
import com.example.jinhui.androiddemo.day20.listviewlistener.ListViewListenerActivity;
import com.example.jinhui.androiddemo.day20.simpleadapter.SimpleAdapter1Activity;
import com.example.jinhui.androiddemo.day20.simpleadapter.SimpleAdapterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class UiOptimize1Activity extends AppCompatActivity {

    @BindView(R.id.bt_arrayadapter)
    Button btArrayadapter;
    @BindView(R.id.bt_simpleadapter)
    Button btSimpleadapter;
    @BindView(R.id.bt_baseadapter)
    Button btBaseadapter;
    @BindView(R.id.bt_example)
    Button btExample;
    @BindView(R.id.bt_listview_listener)
    Button btListviewListener;
    @BindView(R.id.bt_contact)
    Button btContact;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uioptimize1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_arrayadapter, R.id.bt_simpleadapter, R.id.bt_example,
            R.id.bt_baseadapter, R.id.bt_listview_listener,
            R.id.bt_contact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_arrayadapter:
                startActivity(new Intent(this, ArrayAdapterActivity.class));
                break;
            case R.id.bt_simpleadapter:
                startActivity(new Intent(this, SimpleAdapterActivity.class));
                break;
            case R.id.bt_example:
                startActivity(new Intent(this, SimpleAdapter1Activity.class));
                break;
            case R.id.bt_baseadapter:
                startActivity(new Intent(this, BaseAdapterActivity.class));
                break;
            case R.id.bt_listview_listener:
                startActivity(new Intent(this, ListViewListenerActivity.class));
                break;
            case R.id.bt_contact:
                startActivity(new Intent(this, ContactActivity.class));
                break;
        }
    }
}
