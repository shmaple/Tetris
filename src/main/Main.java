package main;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.*;

public class Main {

	public static void main(String[] args) {
		// 创建游戏数据源
		GameDto dto=new GameDto();
		//创建游戏面板
		JPanelGame panelGame=new JPanelGame(dto);
		//创建游戏逻辑块，安装游戏数据源
		GameService gameService=new GameService(dto);
		//创建游戏控制器，连接控制面板和游戏逻辑块
		GameControl gameControl=new GameControl(panelGame,gameService);
		//创建玩家控制器，连接游戏控制器
		PlayerControl control=new PlayerControl(gameControl);
		panelGame.setGameControl(control);
		//创建游戏窗口，并安装游戏面板
		JFrameGame jf=new JFrameGame(panelGame);
		
	}

}
