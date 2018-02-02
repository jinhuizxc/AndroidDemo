package com.example.jinhui.androiddemo.day11.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class TranslateView extends View {

    Paint paint = new Paint();
    Bitmap bitmap;

    public TranslateView(Context context) {
        super(context);
    }

    public TranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
    }

    public TranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 100, 100, paint);

        //保存画布
        canvas.save();

        //3.画布平移
        canvas.translate(200, 0);
        canvas.drawBitmap(bitmap, 100, 100, paint);
        //恢复画布
        canvas.restore();

    }
}
