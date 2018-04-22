package com.example.jinhui.androiddemo.day11_customview.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 自定义textview，设置textview的自定义
 */
public class CalendarTextView extends AppCompatTextView {

    public boolean isToday = false;

    private Paint paint = new Paint();
    public CalendarTextView(Context context) {
        super(context);
    }

    public CalendarTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initControl();
    }

    public CalendarTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl();
    }

    private void initControl(){
        paint.setStyle(Paint.Style.STROKE); // STROKE 描边
        paint.setColor(Color.parseColor("#ff0000"));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isToday){
            canvas.translate(getWidth() / 2, getHeight() / 2);
            canvas.drawCircle(0, 0 , getWidth() / 2, paint);
        }

    }
}
