package dingzhen.dao.sys;

import java.util.Map;

import org.springframework.stereotype.Repository;

import dingzhen.common.base.BaseDao;
import dingzhen.entity.sys.Role;

/**
 *@author: wangq
 *@date: 2015-5-18下午04:53:34
 *@version:
 *@description：
 */
@Repository
@SuppressWarnings({"rawtypes"})
public interface RoleDao extends BaseDao<Role> {

	//通过名称判断是否存在，（新增时不能重名）
	public Role existRoleWithRoleName(String roleName) throws Exception;
	
	//批量删除
	public void deleteRoleByRoleIds(Map map) throws Exception;
}
