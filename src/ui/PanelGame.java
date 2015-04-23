package ui;

import java.awt.Graphics;
//import ui.*;

import javax.swing.*;

public class PanelGame extends JPanel
{
	private Lay[] lays=null;

	public PanelGame()
	{
		//Ӳ����ǳ�LOW������Ӧ��д�ɳ����������ļ�
		lays=new Lay[]{
				new LayBackground(0,0,0,0),
				new LayDataBase(40,32,334,279),
				new LayDisk(40,343,334,279),
				new LayGame(414,32,334,590),
				new LayButton(788,32,334,124),
				new LayNext(788,188,176,148),
				new LayLevel(964,188,158,148),
				new LayPoint(788,368,334,200)
				
		};
	}
	@Override
	public void paintComponent(Graphics g)
	{
		//ˢ�²㴰�ڣ�������Ϸ����
		for(Lay lay:lays)
		{
			lay.paint(g);
		}
	}
}
