package dingzhen.entity.sys;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import dingzhen.common.base.BaseEntity;

/**
 *@author: wangq
 *@date: 2015-5-18下午04:51:51
 *@version:
 *@description：
 */
@Alias("role")
public class Role extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roleId;
	private String roleName;
	private String menuIds;
	private String operationIds;
	private String roleDescription;
	
	
	
	public String getOperationIds() {
		return operationIds;
	}
	public void setOperationIds(String operationIds) {
		this.operationIds = operationIds;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
}
