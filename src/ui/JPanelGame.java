package ui;

import java.awt.Graphics;
//import ui.*;

import javax.swing.*;

public class JPanelGame extends JPanel
{
	private Layer[] lays=null;

	public JPanelGame()
	{
		//硬编码非常LOW，数字应该写成常量或配置文件
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
		//刷新层窗口，绘制游戏窗口
		for(Layer lay:lays)
		{
			lay.paint(g);
		}
	}
}
