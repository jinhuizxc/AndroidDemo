package com.example.jinhui.androiddemo.day12.surfaceview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class GameAnimation {

    //动画坐标位置
    private int posX, posY;

    //动画总帧数
    private int maxFrame;

    //动画当前帧
    private int frame;

    Bitmap bitmap;

    //动画的宽高
    private int width, height;

    // 创建构造方法
    public GameAnimation(int posX, int posY, int maxFrame, Bitmap bitmap) {
        this.posX = posX;
        this.posY = posY;
        this.maxFrame = maxFrame;
        this.bitmap = bitmap;

        this.width = bitmap.getWidth() / maxFrame;
        this.height = bitmap.getHeight();
    }

    public void paint(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.clipRect(posX, posY, posX + width, posY + height);
        canvas.drawBitmap(bitmap, posX - frame * width, posY, paint);
        canvas.restore();
    }

    public void logic() {
        frame = (frame + 1) % maxFrame;
    }
}
