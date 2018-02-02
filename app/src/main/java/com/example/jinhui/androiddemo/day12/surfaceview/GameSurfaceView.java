package com.example.jinhui.androiddemo.day12.surfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 *
 * SurfaceView运行在子线程中

 概念：
 SurfaceView属于View的子类 它是专门为制作游戏而产生的，它的功能非常强大，最重要的是它支持OpenGL ES库，2D和3D的效果都可以实现。

 SurfaceView默认使用双缓冲技术，它支持在子线程中绘制图像，这样就不会阻塞主线程了，所以它更适合于游戏的开发。

 重绘的原理是，程序根据时间来刷新屏幕，如果有一帧图形还没有完全绘制结束，程序就开始刷新屏幕这样就会造成瞬间屏幕闪烁，画面很不美观，所以
 双缓冲的技术：目的就是解决屏幕闪烁的问题。

 SurfaceHolder：
 显示一个surface的抽象接口，使你可以控制surface的大小和格式， 以及在surface上编辑像素，和监视surface的改变。
 这个接口通常通过SurfaceView类实现。

 //给SurfaceView当前的持有者一个回调对象。
 abstract void addCallback(SurfaceHolder.Callback callback);

 //锁定画布，一般在锁定后就可以通过其返回Canvas，在其上面画图等操作了。
 abstract Canvas lockCanvas();

 //结束锁定画图，并提交改变。
 abstract void unlockCanvasAndPost(Canvas canvas);


 SurfaceView的使用方法：
 1.继承SurfaceView
 2.实现接口SurfaceHolder.Callback
 3.获取SurfaceHolder的对象并且设置相关的参数
 4.创建一个线程，在线程中进行绘制

 */

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    Paint paint = new Paint();
    //控制Surface的声明周期
    //从Surface中获取画布，向Surface提交画布
    SurfaceHolder holder;

    boolean isRun = true;

    Bitmap bitmap;
    Bitmap bitmapBom;

    GameAnimation aniBullet;
    GameAnimation aniBoom;
    GameAnimation aniBoom02;

    public GameSurfaceView(Context context) {
        super(context);

//        holder = this.getHolder();
//
//        //  holder.addCallback(this);会实现implements SurfaceHolder.Callback接口，进而实现其3个方法
//        holder.addCallback(this);
//
//        try {
//            bitmap = BitmapFactory.decodeStream(context.getAssets().open("bullet.png"));
//            bitmapBom = BitmapFactory.decodeStream(context.getAssets().open("boom.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        aniBullet = new GameAnimation(100, 100, 4, bitmap);
//        aniBoom = new GameAnimation(100, 150, 7, bitmapBom);
//        aniBoom02 = new GameAnimation(200, 100, 7, bitmapBom);
    }

    public GameSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        holder = this.getHolder();

        //  holder.addCallback(this);会实现implements SurfaceHolder.Callback接口，进而实现其3个方法
        holder.addCallback(this);

        try {
            bitmap = BitmapFactory.decodeStream(context.getAssets().open("bullet.png"));
            bitmapBom = BitmapFactory.decodeStream(context.getAssets().open("boom.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        aniBullet = new GameAnimation(100, 100, 4, bitmap);
        aniBoom = new GameAnimation(100, 150, 7, bitmapBom);
        aniBoom02 = new GameAnimation(200, 100, 7, bitmapBom);
    }

    public GameSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 创建surface时，系统自动调用
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRun = true;
        // 加上线程实现
        new Thread(this).start();
    }

    // surface改变时，系统自动调用
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    // surface销毁时，系统自动调用
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRun = false;
    }

    @Override
    public void run() {
        // 绘制
        while(isRun){

            //获取画布
            Canvas canvas = holder.lockCanvas();

            canvas.drawColor(Color.WHITE);
            //绘制
            canvas.drawColor(Color.argb(50, 0, 0, 255));

            aniBullet.paint(canvas, paint);
            aniBullet.logic();

            aniBoom.paint(canvas, paint);
            aniBoom.logic();

            aniBoom02.paint(canvas, paint);
            aniBoom02.logic();

            //提交画布
            holder.unlockCanvasAndPost(canvas);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
