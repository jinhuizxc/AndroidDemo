package com.example.jinhui.androiddemo.day11_customview.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 自定义日历
 * <p>
 * 实现方式：继承系统控件、组合系统控件、自定义绘制控件
 */

public class CalendarActivity extends AppCompatActivity implements NewCalendar.NewCalendarListener {

    @BindView(R.id.newCalendar)
    NewCalendar newCalendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calendar);
        ButterKnife.bind(this);

        newCalendar.listener = this;

    }

    @Override
    public void onItemLongPress(Date day) {
        DateFormat df = SimpleDateFormat.getDateInstance();
        Toast.makeText(this, df.format(day), Toast.LENGTH_SHORT).show();
    }
}
