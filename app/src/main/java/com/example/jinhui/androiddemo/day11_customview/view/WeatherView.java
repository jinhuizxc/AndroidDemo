package com.example.jinhui.androiddemo.day11_customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 *
 * 天气趋势图得重新做！
 */

public class WeatherView extends View {

    Paint paint = new Paint();
    private String text;

    public WeatherView(Context context) {
        super(context);
    }

    public WeatherView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WeatherView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        if(text != null){
            paint.setColor(Color.WHITE);
            paint.setTextSize(30);
            canvas.drawText(text, 50, 50, paint);
        }
    }

    public void setText(String text){
        this.text = text;
        this.invalidate(); //刷新界面
    }
}
