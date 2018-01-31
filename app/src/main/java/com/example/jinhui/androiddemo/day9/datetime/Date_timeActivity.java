package com.example.jinhui.androiddemo.day9.datetime;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 *
 * 日期对话框和时间对话框
 *
 * DatePicker和TimePicker实现动态输入日期和时间功能。
 当用户更改了DatePicker里的年、月、时，将触发onDateChangedListenner监听器的onDateChange事件。

 */

public class Date_timeActivity extends AppCompatActivity {

    @BindView(R.id.datePicker)
    DatePicker datePicker;
    @BindView(R.id.timePicker)
    TimePicker timePicker;

    String date;
    String time;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datetime);
        ButterKnife.bind(this);

        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        time = new SimpleDateFormat("HH:mm").format(new Date());
        // 设置标题栏当前时间时间
        this.setTitle(date + " " + time);
        //初始化当前时间
        datePicker.init(2016, 7, 29, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                Toast.makeText(Date_timeActivity.this,date,Toast.LENGTH_SHORT).show();
                Date_timeActivity.this.setTitle(date + " " + time);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                time = hourOfDay + ":" + minute;
                Toast.makeText(Date_timeActivity.this,time,Toast.LENGTH_SHORT).show();
                Date_timeActivity.this.setTitle(date + " " + time);
            }
        });
    }

}
