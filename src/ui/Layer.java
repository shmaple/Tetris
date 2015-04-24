package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

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
	private static final int SIZE=7;
	protected static final int PADDING=16;
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
	
	abstract public void paint(Graphics g);

}
