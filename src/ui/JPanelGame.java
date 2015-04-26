package ui;

import java.awt.Graphics;
//import ui.*;




import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import service.GameService;
import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;

public class JPanelGame extends JPanel
{
	//private Layer[] lays=null;
	private ArrayList<Layer> layers=null;
	private GameDto dto;

	public JPanelGame(GameDto dto)
	{
		this.dto=dto;
		//鍒濆鍖栧眰
		initLayer();
		//鍒濆鍖栫粍浠讹紝娣诲姞浜嬩欢鐩戝惉
		initComponent();
	}
	
	
	/**
	 * 鍒濆鍖栧眰
	 */
	private void initLayer()
	{
		try{
		//鑾峰彇娓告垙閰嶇疆淇℃伅绫�
		GameConfig cfg=ConfigFactory.getGameConfig();
		//鑾峰彇娓告垙閰嶇疆淇℃伅绫讳腑鍚勪釜鍥惧眰鐨勯厤缃俊鎭�
		List<LayerConfig> layersCfg=cfg.getLayersConfig();
		//缁樺埗鍚勪釜鍥惧眰锛屽弽灏�
		layers=new ArrayList<Layer>(layersCfg.size());
		for(LayerConfig layercfg:layersCfg)
		{
			//鑾峰彇鍥惧眰绫诲悕
			Class<?> cls=Class.forName(layercfg.getClassName());
			//鑾峰彇鍥惧眰绫荤殑鏋勯�犲嚱鏁�
			Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
			//璋冪敤鏋勯�犲嚱鏁板垱寤哄浘灞�
			Layer layer=(Layer) ctr.newInstance(layercfg.getX(),layercfg.getY(),layercfg.getW(),layercfg.getH());
			layer.dto=this.dto;
			layers.add(layer);
			//System.out.println(layercfg.getClassName());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//纭紪鐮侀潪甯窵OW锛屾暟瀛楀簲璇ュ啓鎴愬父閲忔垨閰嶇疆鏂囦欢
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
	/**
	 * @瀹夎鐜╁鎺у埗鍣�
	 */
	public void setGameControl(PlayerControl control)
	{
		this.addKeyListener(control);
	}
	/**
	 * 鍒濆鍖朿omponent
	 */
	private void initComponent()
	{
	//	GameControl ctl=new GameControl(this);
		//this.addKeyListener(new PlayerControl(new GameControl(this,new GameService())));
	}
	@Override
	public void paintComponent(Graphics g)
	{
		//璋冪敤鍩虹被鏂规硶
		super.paintComponent(g);
		//鍒锋柊灞傜獥鍙ｏ紝缁樺埗娓告垙绐楀彛
		for(Layer lay:layers)
		{
			lay.paint(g);
		}
		//panel鑾峰彇鐒︾偣锛屼笉鐒朵簨浠剁洃鍚笉璧蜂綔鐢�
		this.requestFocus();
	}
}
