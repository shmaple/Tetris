package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {
	private static final Image IMG_LV=new ImageIcon("graphics/string/level.png").getImage();

	public LayerLevel(int x,int y,int w,int h)
	{
		super(x,y,w,h);
	}
	public void paint(Graphics g)
	{
		this.createWindow(g);
		int centX=this.x+(this.w-IMG_LV.getWidth(null)>>1);
		g.drawImage(IMG_LV,centX,this.y+PADDING,null);
		drawNumberLeft(centX-this.x+10,64,this.dto.getNowLeverl(),2,g);
	}

}

