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
	//-----------------------------------------------------------------------------------
	//���Է���
	public void gameTest() {
		
		int point=this.dto.getNowPoint();
		int rmLine=this.dto.getNowRemoveLine();
		int lv =this.dto.getNowLeverl();
		point+=10;
		rmLine+=1;
		if(rmLine%20==0){
			lv+=1;
		}
		this.dto.setNowLeverl(lv);
		this.dto.setNowPoint(point);
		this.dto.setNowRemoveLine(rmLine);
		
	}
	//-----------------------------------------------------------------------------------
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
		//������һ������
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
