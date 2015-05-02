package entity;

import java.awt.Point;

public class GameAct {
	private Point[] actPoints;
	private static final int MIN_X=0;
	private static final int MAX_X=9;
	private static final int MIN_Y=0;
	private static final int MAX_Y=17;
	public GameAct()
	{
		actPoints=new Point[]
				{
					new Point(4,0),
					new Point(3,0),
					new Point(5,0),
					new Point(5,1),
				};
	}
	public Point[] getActPoints() {
		return actPoints;
	}
	public boolean  move(int moveX,int moveY)
	{
		for(Point point:actPoints)
		{
			int newX=point.x+moveX;
			int newY=point.y+moveY;
			if(isOverMap(newX,newY))
				return false;
		}
		for(Point point:actPoints)
		{
			point.x+=moveX;
			point.y+=moveY;
		}
		return true;
	}
	public void round()
	{
		for(int i=1;i<actPoints.length;i++)
		{
			int newX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY=actPoints[0].y-actPoints[0].x+actPoints[i].x;
			if(isOverMap(newX,newY))
				return;
		}
		for(int i=1;i<actPoints.length;i++)
		{
			int newX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY=actPoints[0].y-actPoints[0].x+actPoints[i].x;
			actPoints[i].x=newX;
			actPoints[i].y=newY;
		}
	}
	private boolean isOverMap(int x,int y)
	{
		return x<MIN_X||x>MAX_X||y<MIN_Y||y>MAX_Y;
	}

}
