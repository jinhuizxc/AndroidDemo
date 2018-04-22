package com.example.jinhui.androiddemo.day11_customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day11_customview.canvas.CanvasActivity;
import com.example.jinhui.androiddemo.day11_customview.canvas.ViewActivity;
import com.example.jinhui.androiddemo.day11_customview.view.DragbitmapActivity;
import com.example.jinhui.androiddemo.day11_customview.view.MoveActivity;
import com.example.jinhui.androiddemo.day11_customview.view.OnTouchEventActivity;
import com.example.jinhui.androiddemo.day11_customview.view.WeatherActivity;
import com.example.jinhui.androiddemo.day11_customview.calendar.CalendarActivity;

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
    @BindView(R.id.bt_canvas1)
    Button btCanvas1;
    @BindView(R.id.bt_control)
    Button btControl;
    @BindView(R.id.bt_calendar)
    Button btCalendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanceinterface3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_canvas, R.id.bt_canvas1, R.id.bt_onTouchEvent, R.id.bt_dragbitmap,
            R.id.bt_move, R.id.bt_weather, R.id.bt_control, R.id.bt_calendar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_canvas:
                startActivity(new Intent(this, CanvasActivity.class));
                break;
            case R.id.bt_canvas1:
                startActivity(new Intent(this, ViewActivity.class));
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
            case R.id.bt_control:
                startActivity(new Intent(this, ControlActivity.class));
                break;
            case R.id.bt_calendar:
                startActivity(new Intent(this, CalendarActivity.class));
                break;
        }
    }
}
