package com.example.jinhui.androiddemo.day11_customview.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * atrs xml文件的配置
 * 点击事件
 *
 */
public class NewCalendar extends LinearLayout {

    private ImageView iv_pre;
    private ImageView iv_next;
    private TextView tv_date;
    private GridView gridView;
    private Calendar currentDate = Calendar.getInstance();

    private String displayFormat;

    public NewCalendarListener listener;

    public NewCalendar(Context context) {
        super(context);
    }

    public NewCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
    }

    public NewCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context, attrs);
    }


    // 接口
    public interface NewCalendarListener{
        void onItemLongPress(Date day);
    }

    private void initControl(Context context, AttributeSet attrs) {
        bindControl(context);
        bindControlEvent();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.NewCalendar);
        try {
            displayFormat = typedArray.getString(R.styleable.NewCalendar_dateFormat);
            if (displayFormat == null){
                displayFormat = "MMM yyyy";
            }
        }finally {
            typedArray.recycle();
        }

        // 配置好上面TypedArray在渲染
        renderCalendar();


    }

    private void initControl(Context context){
        bindControl(context);
        bindControlEvent();
        renderCalendar();
    }

    private void bindControlEvent() {

        iv_pre.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                currentDate.add(Calendar.MONTH, -1);
                renderCalendar();
            }
        });

        iv_next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate.add(Calendar.MONTH, 1);
                renderCalendar();
            }
        });
    }

    private void bindControl(Context context) {
        LayoutInflater inflater =  LayoutInflater.from(context);
//        inflater.inflate(R.layout.calendar_view, this, false);
        inflater.inflate(R.layout.calendar_view, this);
        iv_pre = findViewById(R.id.iv_pre);
        iv_next = findViewById(R.id.iv_next);
        tv_date = findViewById(R.id.tv_date);
        gridView = findViewById(R.id.calendar_grid);


    }

    /**
     * 渲染日历
     */
    private void renderCalendar() {

//        SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat(displayFormat);
        tv_date.setText(sdf.format(currentDate.getTime()));

        // gridview data
        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar) currentDate.clone();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int preDays = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        calendar.add(Calendar.DAY_OF_MONTH, -preDays);

        int maxCellsCount = 6*7;
        while (cells.size() < maxCellsCount){
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        gridView.setAdapter(new CalendarAdapter(getContext(), cells));
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                if (listener == null){
                    return false;
                }else {
                    listener.onItemLongPress((Date) parent.getItemAtPosition(position));
                    return true;
                }
//                return false;
            }
        });
    }

    // 适配器
    private class CalendarAdapter extends ArrayAdapter<Date>{

        LayoutInflater inflater;

//        public CalendarAdapter(@NonNull Context context, int resource) {
//            super(context, R.layout.item_calendar_text_day);
//        }

//        public CalendarAdapter(@NonNull Context context, int resource, @NonNull List<Date> objects) {
//            super(context, resource, objects);
//        }

        public CalendarAdapter(@NonNull Context context, ArrayList<Date> days) {
            super(context, R.layout.item_calendar_text_day, days);

            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            Date date = getItem(position);

            if (convertView == null){
                convertView = inflater.inflate(R.layout.item_calendar_text_day, parent, false);
            }

            // 获取当前日期
            int day = date.getDate();
            ((TextView)convertView).setText(String.valueOf(day));


            // 放在这里不能凸显红色，放在下面判断方法后面
//            Date now = new Date();
//            if(now.getDate() == date.getDate() && now.getMonth() == date.getMonth()
//                    && now.getYear() == date.getYear()){
//                ((TextView)convertView).setTextColor(Color.parseColor("#ff0000"));
//            }

            // 方式一：但是不是本月的没变成灰色，看下边代码调整
//            Calendar calendar = (Calendar) currentDate.clone();
//            calendar.set(Calendar.DAY_OF_MONTH, 1);
//            // 获取当月天数
//            int daysInMonth = calendar.getActualMaximum(Calendar.DATE);
//            if (day >= 1 && day <= daysInMonth){
//                ((TextView)convertView).setTextColor(Color.parseColor("#000000"));
//            }else {
//                ((TextView)convertView).setTextColor(Color.parseColor("#666666"));
//            }
            // 方式二：
            Date now = new Date();
            boolean isTheSameMonth = false;
            if (date.getMonth() == now.getMonth()){
                isTheSameMonth = true;
            }

            if (isTheSameMonth){
                ((TextView)convertView).setTextColor(Color.parseColor("#000000"));
            }else {
                ((TextView)convertView).setTextColor(Color.parseColor("#666666"));
            }

//            Date now = new Date();
            if(now.getDate() == date.getDate() && now.getMonth() == date.getMonth()
                    && now.getYear() == date.getYear()){
                ((TextView)convertView).setTextColor(Color.parseColor("#ff0000"));
                ((CalendarTextView)convertView).isToday = true;
            }

            return convertView;
        }
    }






}
