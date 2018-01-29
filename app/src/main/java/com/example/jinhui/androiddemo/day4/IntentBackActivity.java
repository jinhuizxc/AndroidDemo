package com.example.jinhui.androiddemo.day4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 */

public class IntentBackActivity extends AppCompatActivity {

    @BindView(R.id.bt_ok)
    Button btOk;
    @BindView(R.id.et)
    EditText et;
    public static final int RESULT_OK = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentback);
        ButterKnife.bind(this);
    }

    /**
     * setResult()方法的第一个参数值可以根据业务需要自己定义，上面代码中使用到的RESULT_OK是系统Activity类定义的一个常量，值为-1，代码片断如下：
     *
     * public static final int RESULT_CANCELED = 0;
     *
     * public static final int RESULT_OK = -1;
     *
     * public static final int RESULT_FIRST_USER = 1;
     *
     */
    @OnClick(R.id.bt_ok)
    public void onViewClicked() {
        String data = et.getText().toString();
//        Intent intent = new Intent();
//        intent.putExtra("msg", data);
//        // 设置返回的数据
//        setResult(2,intent);
        setResult(RESULT_OK, new Intent().putExtra("msg", data));
        // 销毁当前的activity
        this.finish();
    }
}
