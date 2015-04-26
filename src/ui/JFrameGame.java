package ui;

import java.awt.*;

import javax.swing.*;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame
{

	public JFrameGame(JPanelGame panelGame)
	{
	GameConfig cfg=ConfigFactory.getGameConfig();
	this.setTitle(cfg.getTitle());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(cfg.getWidth(),cfg.getHeight());
	this.setResizable(false);
	//ÆÁÄ»¾ÓÖÐ
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension screen=toolkit.getScreenSize();
	this.setLocation((screen.width-this.getWidth())/2, (screen.height-this.getHeight())/2-cfg.getWindowUp());
	this.setContentPane(panelGame);
	this.setVisible(true);
	}

}
