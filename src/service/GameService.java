package service;

import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	private GameDto dto;
	private Random random=new Random();
	private static final int MAX_TYPE=6;
	public GameService(GameDto dto)
	{
		this.dto=dto;
		GameAct act=new GameAct(random.nextInt(MAX_TYPE));
		this.dto.setGameAct(act);
	}
	//测试方法
	public void gameTest() {
		this.dto.setNowLeverl(this.dto.getNowLeverl()+1);
	}
	public void keyUp() {
		// TODO Auto-generated method stub
	//	if(canMove(0, -1))
		this.dto.getGameAct().round(dto.getGameMap());
	}
	public void keyDown() {
		// TODO Auto-generated method stub
		if(this.dto.getGameAct().move(0, 1,dto.getGameMap())) return;
		boolean[][] map = this.dto.getGameMap();
		Point[] act = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		//生成下一个方块
		this.dto.getGameAct().init(this.dto.getNext());
		this.dto.setNext(random.nextInt(MAX_TYPE));
		
	}
	public void keyRight() {
		// TODO Auto-generated method stub

		this.dto.getGameAct().move(1, 0,dto.getGameMap());
	}
	public void keyLeft() {
		// TODO Auto-generated method stub

		this.dto.getGameAct().move(-1, 0,dto.getGameMap());
	}

	

}
