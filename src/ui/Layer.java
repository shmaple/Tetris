package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author shmaple
 * 
 *
 */
public abstract class Layer {
	/**
	 * 窗口左上角X坐标
	 */
	protected int x;
	
	/**
	 * 窗口左上角Y坐标
	 */
	protected int y;
	/**
	 * 窗口左宽带
	 */
	protected int w;
	/**
	 * 窗口高度
	 */
	protected int h;
	
	/**
	 * 背景边框宽度
	 */
	private static final int SIZE=7;
	protected static final int PADDING=16;
	/**
	 * 背景图片
	 */
	private static Image WINDOW_IMG=new ImageIcon("graphics/window/window.png").getImage();
	/**
	 * 背景图片宽度
	 */
	private static int WINDOW_W=WINDOW_IMG.getWidth(null);
	/**
	 * 背景图片高度
	 */
	private static int WINDOW_H=WINDOW_IMG.getHeight(null);
	
	/**初始化Lay，
	 * @param x:左上角X坐标;
	 * @param y:左上角Y坐标;
	 * @param w:矩形宽度;
	 * @param h:矩形高度;
	 */
	protected Layer(int x,int y,int w,int h)
	{
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	/**绘制含背景图片的矩形边框
	 * 
	 * @param g
	 */
	protected void createWindow(Graphics g)
	{
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE,SIZE, null);
		//中上
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_W-SIZE,SIZE, null);
		//右上
		g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W,SIZE, null);
		//左中
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE,WINDOW_H-SIZE, null);
		//左下
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE,WINDOW_H, null);
		//中下
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE,WINDOW_H, null);
		//右下
		g.drawImage(WINDOW_IMG,x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W,WINDOW_H, null);
		//右中
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W,WINDOW_H-SIZE, null);
		//中
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE,WINDOW_H-SIZE, null);
	}
	
	abstract public void paint(Graphics g);

}
