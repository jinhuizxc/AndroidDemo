package com.example.jinhui.androiddemo.day11_customview.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day11_customview.view.WeatherView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 *
 * 天气预报公共接口：
 网址：http://wthrcdn.etouch.cn/weather_mini?city=武汉
 注意：网址的中文需要转码 URLEncoder.encode("武汉", "utf-8")

 */

public class WeatherActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.editText)
    EditText editText;
//    @BindView(R.id.weatherView)
//    WeatherView weatherView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
//                String text = editText.getText().toString();
//                weatherView.setText(text);
                break;
        }
    }
}
