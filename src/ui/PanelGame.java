package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class PanelGame extends JPanel
{
	public PanelGame()
	{
		
	}
	@Override
	public void paintComponent(Graphics g)
	{
		int size=7;
		Image img=new ImageIcon("graphics/window/Window.png").getImage();
		//g.drawImage(img, 0, 0,null);
		int x=128;
		int y=32;
		int w=320+(size<<1);
		int h=576+(size<<1);
		int picW=img.getWidth(null);
		int picH=img.getHeight(null);
		//左上
		g.drawImage(img, x, y, x+size, y+size, 0, 0, size,size, null);
		//中上
		g.drawImage(img, x+size, y, x+w-size, y+size, size, 0, picW-size,size, null);
		//右上
		g.drawImage(img, x+w-size, y, x+w, y+size, picW-size, 0, picW,size, null);
		//左中
		g.drawImage(img, x, y+size, x+size, y+h-size, 0, size, size,picH-size, null);
		//左下
		g.drawImage(img, x, y+h-size, x+size, y+h, 0, picH-size, size,picH, null);
		//中下
		g.drawImage(img, x+size, y+h-size, x+w-size, y+h, size, picH-size, picW-size,picH, null);
		//右下
		g.drawImage(img,x+w-size, y+h-size, x+w, y+h, picW-size, picH-size, picW,picH, null);
		//右中
		g.drawImage(img, x+w-size, y+size, x+w, y+h-size, picW-size, size, picW,picH-size, null);
		//中
		g.drawImage(img, x+size, y+size, x+w-size, y+h-size, size, size, picW-size,picH-size, null);
	}
}
