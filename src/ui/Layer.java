package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/**
 * @author shmaple
 * 
 *
 */
public abstract class Layer {
	/**
	 * �������Ͻ�X����
	 */
	protected int x;
	
	/**
	 * �������Ͻ�Y����
	 */
	protected int y;
	/**
	 * ��������
	 */
	protected int w;
	/**
	 * ���ڸ߶�
	 */
	protected int h;
	
	/**
	 * �����߿���
	 */
	
	private static final int SIZE;
	protected GameDto dto=null;
	protected static final int PADDING;

	private static final int RECT_H=Img.RECT.getHeight(null);
	private static final int  RECT_W = Img.RECT.getWidth(null);
	private  final int expW;
	protected static final int IMG_NUMBER_W=26;
	private static final int IMG_NUMBER_H=36;
	static
	{
		GameConfig cfg=ConfigFactory.getGameConfig();
		SIZE=cfg.getWindowSize();
		PADDING=cfg.getPadding();
	}
	public void setDto(GameDto dto)
	{
		this.dto=dto;
	}
	/**
	 * ����ͼƬ
	 */
	private static Image WINDOW_IMG=new ImageIcon("graphics/window/window.png").getImage();
	/**
	 * ����ͼƬ���
	 */
	private static int WINDOW_W=WINDOW_IMG.getWidth(null);
	/**
	 * ����ͼƬ�߶�
	 */
	private static int WINDOW_H=WINDOW_IMG.getHeight(null);
	
	/**��ʼ��Lay��
	 * @param x:���Ͻ�X����;
	 * @param y:���Ͻ�Y����;
	 * @param w:���ο��;
	 * @param h:���θ߶�;
	 */
	protected Layer(int x,int y,int w,int h)
	{
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		 expW=this.w-(PADDING<<1);
	}
	/**���ƺ�����ͼƬ�ľ��α߿�
	 * 
	 * @param g
	 */
	protected void createWindow(Graphics g)
	{
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE,SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_W-SIZE,SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W,SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE,WINDOW_H-SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE,WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE,WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMG,x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W,WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W,WINDOW_H-SIZE, null);
		//��
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE,WINDOW_H-SIZE, null);
	}
	
	protected void drawImageActCenter(Image img,Graphics g)
	{
		g.drawImage(img, this.x+(this.w-img.getWidth(null)>>1), this.y+(this.h-img.getHeight(null)>>1), null);
	}
	
	protected void drawNumberLeft(int x,int y,int num,int maxBit,Graphics g)
	{
		String str=Integer.toString(num);
		for (int i = 0; i < maxBit; i++) {
			if(maxBit-i<=str.length())
			{
				int idx=i-maxBit+str.length();
				int bit = str.codePointAt(idx) - '0';
				g.drawImage(Img.NUMBER, 
						this.x + x + i * IMG_NUMBER_W, this.y + y,
						this.x + x + (i + 1) * IMG_NUMBER_W, this.y + y+ IMG_NUMBER_H, 
						bit * IMG_NUMBER_W, 0, (bit + 1)* IMG_NUMBER_W, IMG_NUMBER_H, 
						null);
		}
		}
	}
	
	protected void drawRect(int y,String title,String number,double value,double maxValue,Graphics g)
	{
		int h=32;
		int rect_x=this.x+PADDING;
		int rect_y=this.y+y;
		g.setColor(Color.black);
		g.fillRect(rect_x, rect_y, expW, RECT_H+4);
		g.setColor(Color.white);
		g.fillRect(rect_x+1, rect_y+1, expW-2, RECT_H+2);
		g.setColor(Color.black);
		g.fillRect(rect_x+2, rect_y+2, expW-4, RECT_H);
		
		
		
		//rmLine=19;
		int w =(int)(value/maxValue*(expW-4));
		int subIdx=(int)(value/maxValue*RECT_W);
		g.drawImage(Img.RECT, 
				this.x+PADDING+2, 			rect_y+2,
				this.x+PADDING+2+w, rect_y+2+RECT_H,
				subIdx, 0, subIdx+1, RECT_H, 
				null);
		g.setColor(Color.white);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString(title, rect_x+4, rect_y+22);
		if(number!=null)
		{
			//todo
		}
	}
	abstract public void paint(Graphics g);

}
