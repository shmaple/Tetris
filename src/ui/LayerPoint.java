package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	private static final Image IMG_POINT=new ImageIcon("Graphics/string/point.png").getImage();
	private static final Image IMG_RMLINE=new ImageIcon("Graphics/string/rmline.png").getImage();
	private static final int IMG_POINT_Y=PADDING;
	private static final int IMG_RMLINE_Y=IMG_RMLINE.getHeight(null)+(PADDING<<1);
	private static final int POINT_BIT=5;
	private static  int  POINT_X=0;
	public LayerPoint(int x,int y,int w,int h)
	{
		super(x,y,w,h);
		POINT_X=this.w-this.IMG_NUMBER_W*POINT_BIT-PADDING;
	}
	public void paint(Graphics g)
	{
		this.createWindow(g);
		g.drawImage(IMG_POINT, this.x+PADDING, this.y+IMG_POINT_Y, null);
		drawNumberLeft(POINT_X,IMG_POINT_Y,this.dto.getNowPoint(),POINT_BIT,g);
		
		g.drawImage(IMG_RMLINE, this.x+PADDING, this.y+IMG_RMLINE_Y, null);
		drawNumberLeft(POINT_X,IMG_RMLINE_Y,this.dto.getNowRemoveLine(),POINT_BIT,g);
	}
}
