package com.example.jinhui.androiddemo.day11.move;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.jinhui.androiddemo.R;

public class MyView extends View implements Runnable {

	//画布的宽高
	static int S_WIDTH;
	static int S_HEIGHT;


	public boolean isRun = true;
	Paint paint = new Paint();
	Bitmap bitmap;

	//移动的精灵
	Sprite sprite;

	//虚拟键盘
	MyBoard myBoard;

	public MyView(Context context) {
		super(context);
		bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);

		sprite = new Sprite(bitmap, 200, 200);

		myBoard = new MyBoard(100, 600, 50, sprite);


		new Thread(this).start();
	}



	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		S_WIDTH = this.getWidth();
		S_HEIGHT = this.getHeight();

		// 绘制键盘与图片对象
		paint(canvas);

		logic();

	}

	private void paint(Canvas canvas){
		myBoard.paint(canvas, paint);
		sprite.paint(canvas, paint);
	}

	private void logic(){
		sprite.logic();
	}

	@Override
	public void run() {
		// 耗时
		while (isRun) {
			this.postInvalidate();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		myBoard.onTouchEvent(event);

		return true;
	}
}
