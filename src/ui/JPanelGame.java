package ui;

import java.awt.Graphics;
//import ui.*;




import java.util.List;

import javax.swing.*;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;

public class JPanelGame extends JPanel
{
	private Layer[] lays=null;
	private Layer[] layers=null;

	public JPanelGame()
	{
		GameConfig cfg=ConfigFactory.getGameConfig();
		List<LayerConfig> layersCfg=cfg.getLayersConfig();
		for(LayerConfig layercfg:layersCfg)
		{
			System.out.println(layercfg.getClassName());
		}
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
