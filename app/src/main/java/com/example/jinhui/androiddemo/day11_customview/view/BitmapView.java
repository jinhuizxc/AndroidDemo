package com.example.jinhui.androiddemo.day11_customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 */

public class BitmapView extends View {

    Paint paint = new Paint();

    Bitmap bitmap;

    public BitmapView(Context context) {
        super(context);
    }

    public BitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
    }

    public BitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        //图片的锚点在左上角
        canvas.drawBitmap(bitmap, 0, 0, paint);
        //绘制文字，文字的锚点在左下角
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        canvas.drawText("abcabc", 0, paint.getTextSize(), paint);

        //裁剪画布

//		//保存画布
//		canvas.save();
        //设置裁剪区域
        canvas.clipRect(0, 0, this.getWidth(), 230);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 200, 50, paint);
//		//恢复画布
//		canvas.restore();

        //继续绘制
        paint.setColor(Color.RED);
        canvas.drawRect(0, 300, 100, 400, paint);
    }
}
