package dingzhen.entity.games;

import org.apache.ibatis.type.Alias;

import dingzhen.common.base.BaseEntity;

@Alias("grouping")
public class Grouping extends BaseEntity{

	private String id;
	private String name;
	private String sort;
	private Player player;
	private Events events;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
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
	
}
