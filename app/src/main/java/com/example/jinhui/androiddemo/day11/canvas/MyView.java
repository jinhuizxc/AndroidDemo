package com.example.jinhui.androiddemo.day11.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 *
 * 绘制线段：
 canvas.drawLine(startX, startY, endX, endY, paint);
 //绘制线段
 canvas.drawLine(10,  50, 100, 50, paint);

 绘制矩形：
 canvas.drawRect(left, top, right, bottom, paint);
 //绘制矩形
 canvas.drawRect(10, 60, 100, 150, paint);

 绘制圆：
 canvas.drawCircle(x, y, radius, paint);
 //绘制圆形
 canvas.drawCircle(100, 220, 50, paint);

 绘制路径：
 Path path = new Path();
 path.moveTo(50, 100);
 path.lineTo(50, 200);
 path.lineTo(150, 200);
 path.close();
 canvas.drawPath(path, paint);

 //设置起始点（三角形）
 path.moveTo(0, 10);
 path.lineTo(40, 40);
 path.lineTo(80, 10);
 //		path.lineTo(0, 0);//不需要这句，直接将路径路径关闭即可。
 path.close();
 canvas.drawPath(path, paint);

 绘制文字：
 //文字的锚点坐标在左下角
 canvas.drawText(text, x, y, paint);
 //绘制文字的大小。
 paint.setTextSize(30);
 canvas.drawText("abcabc", 0, paint.getTextSize(), paint);

 绘制位图（Bitmap）：
 创建bitmap找到资源文件
 Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_launcher);
 // 图片的锚点在左上角
 canvas.drawColor(Color.WHITE);
 canvas.drawBitmap(bitmap, 0, 0, paint);

 设置画笔颜色：
 paint.setColor(Color.BLACK);

 消除画笔锯齿：
 paint.setAntiAlias(true);

 设置画笔样式：
 //画笔默认样式为实心FILL。
 paint.setStyle(Style.FILL);

 //将画笔设置为空心STROKE，空心画笔可以加上填充色。
 paint.setStyle(Style.STROKE);

 设置画笔粗细：
 //画笔宽度默认为一个像素
 //将画笔宽度设置为五个像素
 paint.setStrokeWidth(5);

 Canvas画布变换介绍：
 //画布平移
 translate(float dx, float dy)
 //画布旋转
 //rotate(float degrees)
 //画布缩放
 //scale(float x, float y)

 裁剪画布：
 //保存画布
 canvas.save();
 //设置裁剪区域
 canvas.clipRect(0, 0, 200, 100);
 //在画布上绘制图形
 canvas.drawCircle(100, 100, 100, paint);
 //恢复画布
 canvas.restore();
 ####################画布恢复后可以继续绘制。
 //继续绘制
 paint.setColor(Color.RED);
 canvas.drawRect(0, 300, 100, 400, paint);

 */

public class MyView extends View {

    private static final String TAG = "MyView";
    //画笔对象
    Paint paint = new Paint();

    /**
     *  setContentView(new MyView(this));执行的话才会调用此方法，这很正常，无需解释
     * E/MyView: MyView constructor
     * @param context
     */
    public MyView(Context context) {
        super(context);
        Log.e(TAG, "MyView constructor");
    }

    /**
     *  这个方法必定执行，其他2个构造未执行，谨记！：
     *  E/MyView: MyView constructor1
     * @param context
     * @param attrs
     */
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG, "MyView constructor1");
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.e(TAG, "MyView constructor2");
    }

    //canvas 画布对象
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置整个画布颜色为黑色
        canvas.drawColor(Color.BLACK);
        //消除锯齿
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        //画笔宽度默认为一个像素
        //将画笔宽度设置为五个像素
        paint.setStrokeWidth(5);

        // 绘制直线
        canvas.drawLine(10,  50, 100, 50, paint);
        //绘制矩形
        canvas.drawRect(10, 60, 100, 150, paint);
        //设置画笔样式
        //画笔默认样式为实心FILL。
        //将画笔设置为空心STROKE
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        canvas.drawRect(110, 60, 200, 150, paint);
        //绘制圆形
        canvas.drawCircle(100, 220, 50, paint);

        //设为实心画笔
        paint.setStyle(Paint.Style.FILL);

        //绘制路径
        Path path = new Path();
        //设置起始点（三角形）
        path.moveTo(0, 10);
        path.lineTo(40, 40);
        path.lineTo(80, 10);
//		path.lineTo(0, 0);//不需要这句，直接将路径路径关闭即可。
        path.close();
        canvas.drawPath(path, paint);
    }
}
