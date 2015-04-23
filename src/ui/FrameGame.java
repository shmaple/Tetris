package ui;

import java.awt.*;
import java.awt.Toolkit;

import javax.swing.*;

public class FrameGame extends JFrame
{
	private int DEFAULT_WIDTH=1168;
	private int DEFAULT_HEIGHT=680;

	public FrameGame()
	{
	this.setTitle("JAVA¶íÂÞË¹·½¿é");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	this.setResizable(false);
	//ÆÁÄ»¾ÓÖÐ
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension screen=toolkit.getScreenSize();
	this.setLocation((screen.width-this.getWidth())/2, (screen.height-this.getHeight())/2-32);
	this.setContentPane(new PanelGame());
	}

}
