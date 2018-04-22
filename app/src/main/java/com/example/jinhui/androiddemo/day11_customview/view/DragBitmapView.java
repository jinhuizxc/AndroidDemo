package com.example.jinhui.androiddemo.day11_customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/1.
 * Email:1004260403@qq.com
 *
 * 拖动图片会拖出屏幕，这个问题很严重啊，怎么解决？
 */

public class DragBitmapView extends View {

    Paint paint = new Paint();

    Bitmap bitmap;

    int bitmapX, bitmapY;
    int bitmapWidth, bitmapHeight;

    public DragBitmapView(Context context) {
        super(context);
    }

    public DragBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_head);
        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();
    }

    public DragBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);
    }


    private boolean isOnBitmap = false;
    //触摸点和图片锚点的差值
    private int subX, subY;

    /**
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //检测是否按到图片
            if (x > bitmapX && x < bitmapX + bitmapWidth
                    && y > bitmapY && y < bitmapY + bitmapHeight) {
                isOnBitmap = true;
                subX = x - bitmapX;
                subY = y - bitmapY;
            }
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (isOnBitmap) {
                //修正
                bitmapX = x - subX;
                bitmapY = y - subY;
                // 2018/2/1 目前拖动图片会拖出屏幕，图片的锚点是左上角，可以控制下
                if (bitmapX < 0) {
                    bitmapX = 0;
                }else if(bitmapY < 0){
                    bitmapY = 0;
                }else if (bitmapY + bitmapHeight > this.getHeight()){
                    bitmapY = this.getHeight() - bitmapHeight;
                }else if (bitmapX + bitmapWidth > this.getWidth()){
                    bitmapX = this.getWidth() - bitmapWidth;
                }
                this.invalidate();
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            isOnBitmap = false;
        }
        return true;
    }
}
