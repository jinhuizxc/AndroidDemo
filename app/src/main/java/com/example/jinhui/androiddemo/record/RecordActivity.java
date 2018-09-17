package com.example.jinhui.androiddemo.record;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.record.weixin.WeiXinRecordActivity;
import com.example.jinhui.androiddemo.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jh on 2018/9/16.
 * Email: 1004260403@qq.com
 * <p>
 * 微信录音demo: https://github.com/scsfwgy/WeixinRecord
 */
public class RecordActivity extends AppCompatActivity {


    @BindView(R.id.bt_record1)
    Button btRecord1;
    @BindView(R.id.bt_record2)
    Button btRecord2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_record1, R.id.bt_record2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_record1:
                startActivity(new Intent(this, WeiXinRecordActivity.class));
                break;
            case R.id.bt_record2:
                ToastUtil.show(this, "待开发，https://github.com/jinhuizxc/WeixinRecordDemo");
//                startActivity(new Intent(this, WeiXinRecordActivity.class));
                break;
        }

    }
}
