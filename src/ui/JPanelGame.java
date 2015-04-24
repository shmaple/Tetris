package ui;

import java.awt.Graphics;
//import ui.*;

import javax.swing.*;

public class JPanelGame extends JPanel
{
	private Layer[] lays=null;

	public JPanelGame()
	{
		//Ӳ����ǳ�LOW������Ӧ��д�ɳ����������ļ�
		lays=new Layer[]{
				new LayerBackground(0,0,0,0),
				new LayerDataBase(40,32,334,279),
				new LayerDisk(40,343,334,279),
				new LayerGame(414,32,334,590),
				new LayerButton(788,32,334,124),
				new LayerNext(788,188,176,148),
				new LayerLevel(964,188,158,148),
				new LayerPoint(788,368,334,200)
				
		};
	}
	@Override
	public void paintComponent(Graphics g)
	{
		//ˢ�²㴰�ڣ�������Ϸ����
		for(Layer lay:lays)
		{
			lay.paint(g);
		}
	}
}
