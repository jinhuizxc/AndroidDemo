package com.example.jinhui.androiddemo.day21_adapter_footer_header;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day21_adapter_footer_header.addfooter.AddFooter1Activity;
import com.example.jinhui.androiddemo.day21_adapter_footer_header.addfooter.AddFooterActivity;
import com.example.jinhui.androiddemo.day21_adapter_footer_header.chat.ChatActivity;
import com.example.jinhui.androiddemo.day21_adapter_footer_header.example.ExampleActivity;
import com.example.jinhui.androiddemo.day21_adapter_footer_header.pulltorefresh.Add_header_footerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class UiOptimize2Activity extends AppCompatActivity {

    @BindView(R.id.bt_chat)
    Button btChat;
    @BindView(R.id.bt_add_footer)
    Button btAddFooter;
    @BindView(R.id.bt_add_footer1)
    Button btAddFooter1;
    @BindView(R.id.bt_add_header_footer)
    Button btAddHeaderFooter;
    @BindView(R.id.bt_example)
    Button btExample;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uioptimize2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_chat, R.id.bt_add_footer, R.id.bt_add_footer1,
            R.id.bt_add_header_footer, R.id.bt_example})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_chat:
                startActivity(new Intent(this, ChatActivity.class));
                break;
            case R.id.bt_add_footer:
                startActivity(new Intent(this, AddFooterActivity.class));
                break;
            case R.id.bt_add_footer1:
                startActivity(new Intent(this, AddFooter1Activity.class));
                break;
            case R.id.bt_add_header_footer:
                startActivity(new Intent(this, Add_header_footerActivity.class));
                break;
            case R.id.bt_example:
//                Toast.makeText(this, "2018/2/4  -看github", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ExampleActivity.class));
                break;
        }
    }

}
