package ui;

import java.awt.Graphics;
//import ui.*;

import javax.swing.*;

public class PanelGame extends JPanel
{
	private Lay[] lays=null;

	public PanelGame()
	{
		//硬编码非常LOW，数字应该写成常量或配置文件
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
		//刷新层窗口，绘制游戏窗口
		for(Lay lay:lays)
		{
			lay.paint(g);
		}
	}
}
