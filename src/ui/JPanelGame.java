package ui;

import java.awt.Graphics;
//import ui.*;




import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;

public class JPanelGame extends JPanel
{
	//private Layer[] lays=null;
	private ArrayList<Layer> layers=null;

	public JPanelGame()
	{
		try{
		//获取游戏配置信息类
		GameConfig cfg=ConfigFactory.getGameConfig();
		//获取游戏配置信息类中各个图层的配置信息
		List<LayerConfig> layersCfg=cfg.getLayersConfig();
		//绘制各个图层，反射
		layers=new ArrayList<Layer>(layersCfg.size());
		for(LayerConfig layercfg:layersCfg)
		{
			//获取图层类名
			Class<?> cls=Class.forName(layercfg.getClassName());
			//获取图层类的构造函数
			Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
			//调用构造函数创建图层
			layers.add((Layer) ctr.newInstance(layercfg.getX(),layercfg.getY(),layercfg.getW(),layercfg.getH()));
			//System.out.println(layercfg.getClassName());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//硬编码非常LOW，数字应该写成常量或配置文件
//		lays=new Layer[]{
//				new LayerBackground(0,0,0,0),
//				new LayerDataBase(40,32,334,279),
//				new LayerDisk(40,343,334,279),
//				new LayerGame(414,32,334,590),
//				new LayerButton(788,32,334,124),
//				new LayerNext(788,188,176,148),
//				new LayerLevel(964,188,158,148),
//				new LayerPoint(788,368,334,200)
//				
//		};
	}
	@Override
	public void paintComponent(Graphics g)
	{
		//刷新层窗口，绘制游戏窗口
		for(Layer lay:layers)
		{
			lay.paint(g);
		}
	}
}
