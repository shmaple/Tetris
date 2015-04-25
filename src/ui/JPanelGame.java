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
		//��ȡ��Ϸ������Ϣ��
		GameConfig cfg=ConfigFactory.getGameConfig();
		//��ȡ��Ϸ������Ϣ���и���ͼ���������Ϣ
		List<LayerConfig> layersCfg=cfg.getLayersConfig();
		//���Ƹ���ͼ�㣬����
		layers=new ArrayList<Layer>(layersCfg.size());
		for(LayerConfig layercfg:layersCfg)
		{
			//��ȡͼ������
			Class<?> cls=Class.forName(layercfg.getClassName());
			//��ȡͼ����Ĺ��캯��
			Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
			//���ù��캯������ͼ��
			layers.add((Layer) ctr.newInstance(layercfg.getX(),layercfg.getY(),layercfg.getW(),layercfg.getH()));
			//System.out.println(layercfg.getClassName());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Ӳ����ǳ�LOW������Ӧ��д�ɳ����������ļ�
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
		//ˢ�²㴰�ڣ�������Ϸ����
		for(Layer lay:layers)
		{
			lay.paint(g);
		}
	}
}
