package com.example.jinhui.androiddemo.day9.datetime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 *
 * DatePickerDialog和TimePickerDialog实现动态输入日期和时间的对话框。
 当用户更改了TimePicker里的时、分时，将触发OnTimeChangedListenner监听器的onTimeChanged事件。
 练习：
 默认在标题栏中展示当前日期和时间，通过监听器去获取用户选择日期或者时间结果，并将变更的日期或者时间显示在标题栏上。

 */

public class ModifyDate_timeActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifydatetime);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                // 弹出日期对话框
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        Toast.makeText(ModifyDate_timeActivity.this, "设置时间:" + year + "-" + (monthOfYear+1) + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
                        ModifyDate_timeActivity.this.setTitle(year + "-" + (monthOfYear+1) + "-" + dayOfMonth);
                    }
                }, year, month, day).show();
                break;
            case R.id.button2:
                // 弹出时间对话框
                Calendar calendar1 = Calendar.getInstance();
                int hour = calendar1.get(Calendar.HOUR_OF_DAY);
                int minute = calendar1.get(Calendar.MINUTE);

                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                    //用户点击对话框上的set按钮时，系统自动调用
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ModifyDate_timeActivity.this.setTitle(hourOfDay + ":" + minute);
                        Toast.makeText(ModifyDate_timeActivity.this, "设置时间:" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, hour, minute, true).show();
                break;
        }
    }
}
