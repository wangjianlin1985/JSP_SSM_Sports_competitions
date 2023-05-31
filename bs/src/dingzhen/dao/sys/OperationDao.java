package dingzhen.dao.sys;


import org.springframework.stereotype.Repository;

import dingzhen.common.base.BaseDao;
import dingzhen.entity.sys.Operation;

/**
 *@author: wangq
 *@date: 2015-8-6下午05:23:42
 *@version:
 *@description：
 */
@Repository
public interface OperationDao extends BaseDao<Operation>{
	public void deleteByMenuId(String menuId) throws Exception;
}
