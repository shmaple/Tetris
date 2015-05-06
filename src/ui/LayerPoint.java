package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {


	private static final int POINT_BIT=5;
	private static final int LEVEL_UP=20;

	private  final int pointY;
	private  final int rmLineY;
	private  final int  comX;
	private  final int  expY;
	//private  final int  expW;
	
	public LayerPoint(int x,int y,int w,int h)
	{
		super(x,y,w,h);
		comX=this.w-Layer.IMG_NUMBER_W*POINT_BIT-PADDING;
		 rmLineY=this.pointY+Img.RMLINE.getHeight(null)+(PADDING<<1);
		 pointY=PADDING;
		 expY=this.rmLineY+Img.RMLINE.getHeight(null)+PADDING;
		
	}
	public void paint(Graphics g)
	{
		this.createWindow(g);
		g.drawImage(Img.POINT, this.x+PADDING, this.y+pointY, null);
		drawNumberLeft(comX,pointY,this.dto.getNowPoint(),POINT_BIT,g);
		
		g.drawImage(Img.RMLINE, this.x+PADDING, this.y+rmLineY, null);
		drawNumberLeft(comX,rmLineY,this.dto.getNowRemoveLine(),POINT_BIT,g);
		int rmLine=this.dto.getNowRemoveLine();
		this.drawRect(expY,"ÏÂÒ»¼¶",null,(double)rmLine%LEVEL_UP,(double)LEVEL_UP, g);

	}

	
//	@Deprecated
//	private Color getNowColor(double hp,double maxHp)
//	{
//		int colorR=0;
//		int colorG=255;
//		int colorB=0;
//		double hpHalf=maxHp/2;
//		if(hp>hpHalf)
//		{
//			colorR=255-(int)((hp-hpHalf)/(maxHp/2)*255);
//			colorG=255;
//		}
//		else
//		{
//			colorR=255;
//			colorG=(int)(hp/(maxHp/2)*255);
//		}
//		return new Color(colorR,colorG,colorB);
//	}
}
