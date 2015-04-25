package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * ��xml�ĵ��ж�ȡ������Ϸ����
 * @author shmaple-work
 *
 */
public class GameConfig {
	/**
	 * ���ڿ��
	 */
	private int width;
	/**
	 * ���ڸ߶�
	 */
	private int height;
	/**
	 * �߿�ߴ�
	 */
	private int windowSize;
	/**
	 * �߿��ڱ߾�
	 */
	private int padding;
	/**
	 * ͼ������
	 */
	private List<LayerConfig> layersConfig;
	/**
	 * ���캯������ȡXML�ļ�����ȡ��Ϸȫ��������Ϣ
	 * @throws DocumentException
	 */
	public GameConfig() throws DocumentException
	{
		//xml������
		SAXReader reader=new SAXReader();
		//��ȡxml�ĵ�
		Document doc=reader.read("config/cfg.xml");
		//��ȡxml���ڵ�
		Element game=doc.getRootElement();
		//����UI����
		setUiConfig(game.element("frame"));
		//����ϵͳ����
		//setUiConfig(game.element("system"));
		//�������ݿ����
		//setUiConfig(game.element("data"));
		
	}
	/**
	 * ���ý������
	 * @param frame������������ڵ�
	 */
	private void setUiConfig(Element frame)
	{
		this.width=Integer.parseInt(frame.attributeValue("width"));
		this.height=Integer.parseInt(frame.attributeValue("height"));
		this.windowSize=Integer.parseInt(frame.attributeValue("windowsize"));
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		List<Element> layers=frame.elements("layer");
		layersConfig=new ArrayList<LayerConfig>();
		for(Element layer:layers)
		{
			LayerConfig lc=new LayerConfig(
			layer.attributeValue("className"),
			Integer.parseInt(layer.attributeValue("x")),
			Integer.parseInt(layer.attributeValue("y")),
			Integer.parseInt(layer.attributeValue("w")),
			Integer.parseInt(layer.attributeValue("h")));
			layersConfig.add(lc);
		}
	}
	public List<LayerConfig> getLayersConfig()
	{
		return layersConfig;
	}
	private void setSystemConfig(Element frame)
	{
		
	}
	private void setDataConfig(Element frame)
	{
		
	}

}
