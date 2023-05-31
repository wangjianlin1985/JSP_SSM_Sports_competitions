package dingzhen.entity.sys;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 *@author: wangq
 *@date: 2015-5-18下午04:19:15
 *@version:
 *@description：
 */
@Alias("menu")
public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String menuId;
	private String menuName;
	private String menuUrl;
	private String parentId;
	private String menuDescription;
	private String state;
	private String iconCls;
	private Integer seq;
	private String[] menuIds;
	
	// 操作按钮名称合集
	private String operations;
	
	
	
	
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public String[] getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String[] menuIds) {
		this.menuIds = menuIds;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
}
