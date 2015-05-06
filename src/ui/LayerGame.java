package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LayerGame extends Layer {
	
	private static int ACT_SIZE=32;
	public LayerGame(int x,int y,int w,int h)
	{
		super(x,y,w,h);
	}
	public void paint(Graphics g)
	{
		this.createWindow(g);

		Point[] points=dto.getGameAct().getActPoints();
		int typeCode=this.dto.getGameAct().getTypeCode();
		for(Point point:points)
		{
			//System.out.println(this.x+point.x*ACT_SIZE);
			g.drawImage(Img.ACT, 
					this.x+point.x*ACT_SIZE+7, 
					this.y+point.y*ACT_SIZE+7,
					this.x+point.x*ACT_SIZE+ACT_SIZE+7, 
					this.y+point.y*ACT_SIZE+ACT_SIZE+7, 
					(typeCode+1)*ACT_SIZE, 0, (typeCode+2)*ACT_SIZE, ACT_SIZE, null);
		}
		 boolean[][] map=this.dto.getGameMap();
		 for(int x=0;x<map.length;x++)
			 for(int y=0; y<map[x].length;y++)
			 {
				 if(map[x][y])
				 {
				 g.drawImage(Img.ACT, 
							this.x+x*ACT_SIZE+7, 
							this.y+y*ACT_SIZE+7,
							this.x+x*ACT_SIZE+ACT_SIZE+7, 
							this.y+y*ACT_SIZE+ACT_SIZE+7, 
							0, 0, 32, 32, null);
				 }
			 }
	}
}
