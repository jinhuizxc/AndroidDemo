package com.example.jinhui.androiddemo.day11_customview.move;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Sprite {


	// 速度
	int speed = 10;

	// 状态机模式

	// 向右移动
	final int RIGHT = 0x02;
	// 向左移动
	final int LEFT = 0x01;
	final int UP = 0X03;
	final int DOWN = 0x00;

	// 方向
	private int dir = RIGHT;

	final int RUN = 0x01;
	final int STAND = 0X02;

	//状态
	private int status = STAND;


	private GameAnimation ani;

	//精灵坐标
	private int x;
	private int y;

	//精灵宽高
	private int width;
	private int height;

	public Sprite(Bitmap bitmap, int x, int y) {

		//创建动画
		this.ani = new GameAnimation(x, y, 3, bitmap, 4);;
		//设置动画坐标
		this.ani.setPosX(x);
		this.ani.setPosY(y);
		//设置动画类型
		this.ani.setAnimation(dir);

		//更新精灵坐标
		this.x = x;
		this.y = y;

		this.width = ani.getWidth();
		this.height = ani.getHeight();
	}

	public void paint(Canvas canvas, Paint paint) {
		ani.paint(canvas, paint);
	}

	public void logic() {

		ani.logic();

		if(status == RUN){

			switch (dir) {
				case UP:
					y -= speed;
					break;

				case DOWN:

					y += speed;
					break;

				case RIGHT:

					x += speed;
					break;

				case LEFT:

					x -= speed;
					break;

			}

			//防止精灵走出屏幕
			if(x > MyView.S_WIDTH-width){
				x = MyView.S_WIDTH-width;
			}else if(x < 0){
				x = 0;
			}

			if(y > MyView.S_HEIGHT - height){
				y = MyView.S_HEIGHT - height;
			}else if(y < 0){
				y = 0;
			}

			ani.setPosX(x);
			ani.setPosY(y);

		}else if(status == STAND){

		}
	}

	public void changeState(int status){
		this.status = status;
	}

	public void setDir(int dir){
		//移动方向
		this.dir = dir;
		//动画的方向
		ani.setAnimation(dir);
	}
}
