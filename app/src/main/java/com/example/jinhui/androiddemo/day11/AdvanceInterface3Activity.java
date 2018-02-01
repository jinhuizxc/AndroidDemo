package com.example.jinhui.androiddemo.day11;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day11.view.CanvasActivity;
import com.example.jinhui.androiddemo.day11.view.DragbitmapActivity;
import com.example.jinhui.androiddemo.day11.view.MoveActivity;
import com.example.jinhui.androiddemo.day11.view.OnTouchEventActivity;
import com.example.jinhui.androiddemo.day11.view.WeatherActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 */

public class AdvanceInterface3Activity extends AppCompatActivity {

    @BindView(R.id.bt_canvas)
    Button btCanvas;
    @BindView(R.id.bt_onTouchEvent)
    Button btOnTouchEvent;
    @BindView(R.id.bt_dragbitmap)
    Button btDragbitmap;
    @BindView(R.id.bt_move)
    Button btMove;
    @BindView(R.id.bt_weather)
    Button btWeather;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanceinterface3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_canvas, R.id.bt_onTouchEvent, R.id.bt_dragbitmap,
            R.id.bt_move, R.id.bt_weather})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_canvas:
                startActivity(new Intent(this, CanvasActivity.class));
                break;
            case R.id.bt_onTouchEvent:
                startActivity(new Intent(this, OnTouchEventActivity.class));
                break;
            case R.id.bt_dragbitmap:
                startActivity(new Intent(this, DragbitmapActivity.class));
                break;
            case R.id.bt_move:
                startActivity(new Intent(this, MoveActivity.class));
                break;
            case R.id.bt_weather:
                startActivity(new Intent(this, WeatherActivity.class));
                break;
        }
    }
}
