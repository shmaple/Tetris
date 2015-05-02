package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	public GameDto()
	{
		dtoInit();
	}
	public void dtoInit()
	{
		this.gameMap=new boolean[10][18];
	}
	/**
	 * 数据库记录
	 */
	private List<Player> dbRecode;
	/**
	 * 本地记录
	 */
	private List<Player> diskRecode;
	/**
	 * 游戏方框阵列中是否存在方框
	 */
	private boolean[][] gameMap;
	/**
	 * 下落方块
	 */
	private GameAct gameAct;
	/**
	 * 下一个方块图形序号
	 */
	private int next;
	/**
	 * 当前等级
	 */
	private int nowLeverl;
	/**
	 * 当前分数
	 */
	private int nowPoint;
	/**
	 * 当前消除行数
	 */
	private int nowRemoveLine;
	/**
	 * @return
	 */
	public List<Player> getDbRecode() {
		return dbRecode;
	}
	/**
	 * @param dbRecode
	 */
	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = dbRecode;
	}
	/**
	 * @return
	 */
	public List<Player> getDiskRecode() {
		return diskRecode;
	}
	/**
	 * @param diskRecode
	 */
	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = diskRecode;
	}
	/**
	 * @return
	 */
	public boolean[][] getGameMap() {
		return gameMap;
	}
	/**
	 * @param gameMap
	 */
	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}
	/**
	 * @return
	 */
	public GameAct getGameAct() {
		return gameAct;
	}
	/**
	 * @param gameAct
	 */
	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}
	/**
	 * @return
	 */
	public int getNext() {
		return next;
	}
	/**
	 * @param next
	 */
	public void setNext(int next) {
		this.next = next;
	}
	/**
	 * @return
	 */
	public int getNowLeverl() {
		return nowLeverl;
	}
	/**
	 * @param leverl
	 */
	public void setNowLeverl(int leverl) {
		this.nowLeverl = leverl;
	}
	/**
	 * @return
	 */
	public int getNowPoint() {
		return nowPoint;
	}
	/**
	 * @param nowPoint
	 */
	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}
	/**
	 * @return
	 */
	public int getNowRemoveLine() {
		return nowRemoveLine;
	}
	/**
	 * @param nowRemoveLine
	 */
	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}

}
