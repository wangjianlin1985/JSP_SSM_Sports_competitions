package dingzhen.entity.games;

import org.apache.ibatis.type.Alias;

import dingzhen.common.base.BaseEntity;

/**
 * @author wangqun
 * @date 2018年3月5日 下午6:04:11
 * @version 0.0.1
 * @description 
 */
@Alias("notice")
public class Notice extends BaseEntity{
	private String id;
	private String title;
	private String content;
	private String time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
