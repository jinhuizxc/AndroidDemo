package com.example.jinhui.androiddemo.day11.move;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class MyBoard {

    //虚拟键盘的坐标
    private int x, y;

    //虚拟键盘一个按键的宽度
    private int width;

    private Sprite sprite;

    public MyBoard(int x, int y, int width, Sprite sprite) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.sprite = sprite;
    }

    public void paint(Canvas canvas, Paint paint) {

        paint.setColor(Color.BLACK);
        //上
        canvas.drawRect(x + width, y, x + 2 * width, y + width, paint);
        //下
        canvas.drawRect(x + width, y + 2 * width, x + 2 * width, y + 3 * width, paint);
        //左
        canvas.drawRect(x, y + width, x + width, y + 2 * width, paint);
        //右
        canvas.drawRect(x + 2 * width, y + width, x + 3 * width, y + 2 * width, paint);
    }


    public boolean onTouchEvent(MotionEvent event) {

        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if (touchX > x + width && touchX < x + 2 * width
                    && touchY > y && touchY < y + width) {
                //上
                sprite.changeState(sprite.RUN);
                sprite.setDir(sprite.UP);

            } else if (touchX > x + width && touchX < x + 2 * width
                    && touchY > y + 2 * width && touchY < y + 3 * width) {
                //下
                sprite.changeState(sprite.RUN);
                sprite.setDir(sprite.DOWN);
            }

            //x, y+width, width, y+2*width
            else if (touchX > x && touchX < x + width
                    && touchY > y + width && touchY < y + 2 * width) {
                //左
                sprite.changeState(sprite.RUN);
                sprite.setDir(sprite.LEFT);
            } else if (touchX > x + 2 * width && touchX < x + 3 * width
                    && touchY > y + width && touchY < y + 2 * width) {
                //右
                sprite.changeState(sprite.RUN);
                sprite.setDir(sprite.RIGHT);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            sprite.changeState(sprite.STAND);
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

        }
        return true;
    }

}
