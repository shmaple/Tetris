package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	private Point[] actPoints=null;
	private int  typeCode;
	private static final int MIN_X=0;
	private static final int MAX_X=9;
	private static final int MIN_Y=0;
	private static final int MAX_Y=17;
	
	private static  List<Point[]> TYPE_CONFIG;
	static
	{
		TYPE_CONFIG=new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4,0),	new Point(3,0),	new Point(5,0),	new Point(6,0)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),	new Point(3,0),	new Point(5,0),	new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),	new Point(3,0),	new Point(5,0),	new Point(3,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),	new Point(5,0),	new Point(3,1),	new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),	new Point(5,0),	new Point(4,1),	new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),	new Point(3,0),	new Point(5,0),	new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),	new Point(3,0),	new Point(4,1),	new Point(5,1)});
	}
	public GameAct(int typeCode)
	{
		init(typeCode);
	}
	public void init(int typeCode)
	{
		this.typeCode=typeCode;
		//传智与传址，无法理解
		Point[] points=TYPE_CONFIG.get(typeCode);
		
		actPoints= new Point[points.length];
		actPoints=TYPE_CONFIG.get(1);
		for(int i=0;i<points.length;i++)
		{
			actPoints[i]=new Point(points[i].x,points[i].y);
			//System.out.print(" x="+points[i].x+" y="+points[i].y+";");
		}
////		for(Point point:TYPE_CONFIG.get(0))
////		{
////			System.out.print(" x="+point.x+" y="+point.y+";");
////		}
////		System.out.println();
//		for(Point[] p:TYPE_CONFIG)
//		{
//			for(Point pp:p)
//			{
//				System.out.print(" x="+pp.x+" y="+pp.y+";");
//				//System.out.println();
//			}
//			System.out.println("------------------------------------------------");
//		}
	}
	public int getTypeCode() {
		return typeCode;
	}
	public Point[] getActPoints() {
		return actPoints;
	}
	public boolean  move(int moveX,int moveY,boolean[][] gameMap)
	{
		for(Point point:actPoints)
		{
			int newX=point.x+moveX;
			int newY=point.y+moveY;
			if(isOverZone(newX,newY,gameMap))
				return false;
		}
		for(Point point:actPoints)
		{
			point.x+=moveX;
			point.y+=moveY;
		}
		return true;
	}
	public void round(boolean[][] gameMap)
	{
		if(this.typeCode==4) return;
		for(int i=1;i<actPoints.length;i++)
		{
			int newX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY=actPoints[0].y-actPoints[0].x+actPoints[i].x;
			if(isOverZone(newX,newY,gameMap))
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
	private boolean isOverZone(int x,int y,boolean[][] gameMap)
	{
		return x<MIN_X||x>MAX_X||y<MIN_Y||y>MAX_Y||gameMap[x][y];
	}

}
