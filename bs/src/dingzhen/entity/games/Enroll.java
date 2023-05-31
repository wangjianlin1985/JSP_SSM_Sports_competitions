package dingzhen.entity.games;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import dingzhen.common.base.BaseEntity;
import dingzhen.entity.games.Events;
import dingzhen.entity.games.Player;

/**
 * @author wangqun
 * @date 2018年3月3日 上午9:58:43
 * @version 0.0.1
 * @description 
 */
@Alias("enroll")
public class Enroll extends BaseEntity implements Serializable{

	private String id;
	private Player player;  // 运动员
	private Events events;  // 项目
	private String yscore;  // 预赛成绩
	private String jscore;  // 决赛成绩
	private String breakrecord;  // 打破记录
	
	
	
	public String getBreakrecord() {
		return breakrecord;
	}
	public void setBreakrecord(String breakrecord) {
		this.breakrecord = breakrecord;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public String getYscore() {
		return yscore;
	}
	public void setYscore(String yscore) {
		this.yscore = yscore;
	}
	public String getJscore() {
		return jscore;
	}
	public void setJscore(String jscore) {
		this.jscore = jscore;
	}
	@Override
	public String toString() {
		return "Enroll [id=" + id + ", player=" + player + ", events=" + events
				+ ", yscore=" + yscore + ", jscore=" + jscore
				+ ", breakrecord=" + breakrecord + "]";
	}
	
	
}
