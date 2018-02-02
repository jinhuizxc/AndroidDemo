package com.example.jinhui.androiddemo.day14.calculator;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class CalculatorActivity extends AppCompatActivity {

    @BindView(R.id.et_num1)
    EditText etNum1;
    @BindView(R.id.et_num2)
    EditText etNum2;
    @BindView(R.id.bt_bindcalculator)
    Button btBindcalculator;
    @BindView(R.id.bt_unbindcalculator)
    Button btUnbindcalculator;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);
    }

    /**
     * trim(字串):
     * 将字串首尾两端的空格移除,作用等于RTRIM和LTRIM两个函数共同的结果。
     *
     * @param view
     */
    @OnClick({R.id.bt_bindcalculator, R.id.bt_unbindcalculator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bindcalculator:
                Intent intent = new Intent(this, CalculatorService.class);
                intent.putExtra("opt01", Integer.parseInt(etNum1.getText().toString().trim()));
                intent.putExtra("opt02", Integer.parseInt(etNum2.getText().toString().trim()));

                bindService(intent, conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.bt_unbindcalculator:
                //解除绑定
                unbindService(conn);
                break;
        }
    }

    public ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            CalculatorService.CalculatorBinder myBinder = (CalculatorService.CalculatorBinder) service;
            int result = myBinder.getResult();
            tvResult.setText(String.valueOf(result));
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
