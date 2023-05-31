package dingzhen.service.sys;

import java.util.Map;

import dingzhen.common.base.BaseService;
import dingzhen.entity.sys.Role;

/**
 *@author: wangq
 *@date: 2015-5-18下午04:57:31
 *@version:
 *@description：
 */
public interface RoleService  extends BaseService<Role> {
	
	//通过名称判断是否存在，（新增时不能重名）
	public Role existRoleWithRoleName(String roleName) throws Exception;
	
	//批量删除
	@SuppressWarnings({ "rawtypes" })
	public void deleteRoleByRoleIds(Map map) throws Exception;
}
