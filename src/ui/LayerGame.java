package ui;

import java.awt.Font;
import java.awt.Graphics;

public class LayerGame extends Layer {
	public LayerGame(int x,int y,int w,int h)
	{
		super(x,y,w,h);
	}
	public void paint(Graphics g)
	{
		this.createWindow(g);
		g.setFont(new Font("ºÚÌå",Font.BOLD,64));
		String tempString=Integer.toString(this.dto.getNowPoint());
		g.drawString(tempString, this.x+PADDING, this.y+PADDING+64);
	}
}
