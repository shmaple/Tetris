package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayBackground extends Lay {
	private static Image IMG_BG=new ImageIcon("graphics/background/sea.jpg").getImage();
	public LayBackground(int x,int y,int w,int h)
	{
		super(x,y,w,h);
	}
	public void paint(Graphics g)
	{
		this.createWindow(g);
		g.drawImage(IMG_BG,0,0,1162,654,null);
	}
}
