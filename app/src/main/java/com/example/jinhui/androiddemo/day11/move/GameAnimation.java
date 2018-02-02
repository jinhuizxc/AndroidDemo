package com.example.jinhui.androiddemo.day11.move;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

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

	//动画标号
	private int animationIndex;

	//动画数量
	private int animationNumber;

	//图片中只包含一个动画
	public GameAnimation(int posX, int posY, int maxFrame, Bitmap bitmap) {
		this.posX = posX;
		this.posY = posY;
		this.maxFrame = maxFrame;
		this.bitmap = bitmap;

		this.width = bitmap.getWidth()/maxFrame;
		this.height = bitmap.getHeight();
	}

	//图片中包含多个动画
	public GameAnimation(int posX, int posY, int maxFrame, Bitmap bitmap, int animationNumber) {
		this(posX, posY, maxFrame, bitmap);
		this.animationNumber = animationNumber;

		this.height = bitmap.getHeight()/animationNumber;
	}

	//设置动画种类 （动画的编号和方向值一致）
	public void setAnimation(int index){
		this.animationIndex = index;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void paint(Canvas canvas, Paint paint){
		canvas.save();
		canvas.clipRect(posX, posY, posX+width, posY+height);
		canvas.drawBitmap(bitmap, posX-frame*width, posY-animationIndex*height, paint);
		canvas.restore();
	}

	public void logic(){

		frame = (frame+1)%maxFrame;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
