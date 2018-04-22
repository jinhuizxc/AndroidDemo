package com.example.jinhui.androiddemo.day11_customview.ontouchevent;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 */

public class TouchEventView extends View {

    private static final String TAG = "TouchEventView";
    Paint paint = new Paint();

    int radius = 50;

    //保存圆心坐标
    ArrayList<MyPoint> data = new ArrayList<MyPoint>();

    public TouchEventView(Context context) {
        super(context);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);

        paint.setColor(Color.WHITE);

        //绘制圆
        for (int i = 0; i < data.size(); i++) {
            canvas.drawCircle(data.get(i).getX(), data.get(i).getY(), radius, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        // 获取触摸点坐标
        Log.e(TAG, "(" + x + "," + y + ")");

        // 触摸动作 （按下，松开，滑动）

        //触摸动作，默认只能检测到down。
        //如果想检测另外两个动作，必须将返回值改为true

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.e(TAG, "down");
            //添加圆心坐标
            MyPoint point = new MyPoint(x, y);
            data.add(point);
            //发送消息，让系统自动调用onDraw方法
            this.invalidate();

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.e(TAG, "up");
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            Log.e(TAG, "move");
        }

        return true;
//        return super.onTouchEvent(event);
    }
}
