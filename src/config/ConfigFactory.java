package config;

import org.dom4j.DocumentException;

public class ConfigFactory {
	private static GameConfig GAME_CONFIG;
	static
	{
		try {
			GAME_CONFIG=new GameConfig();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static GameConfig getGameConfig()
	{
		return GAME_CONFIG;
	}
}
