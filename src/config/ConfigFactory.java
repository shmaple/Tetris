package config;
/**
 * 工厂类，用于封装GameConfig类，确保该类在整个程序中只被调用一次。
 * @author shmaple-work
 *
 */
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
