package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {
	private static final Image[] NEXT_ACT;
	static{
		NEXT_ACT=new Image[7];
		for(int i=0;i<NEXT_ACT.length;i++)
		{
			NEXT_ACT[i]=new ImageIcon("Graphics/game/"+i+".png").getImage();
		}
	}
	public LayerNext(int x,int y,int w,int h)
	{
		super(x,y,w,h);
	}
	public void paint(Graphics g)
	{
		this.createWindow(g);
		this.drawImageActCenter(NEXT_ACT[this.dto.getNext()], g);
		//g.drawImage, this.x+32, this.y+32,null);
	}
}
