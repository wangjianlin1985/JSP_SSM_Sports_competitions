package dingzhen.service.sys;


import dingzhen.common.base.BaseService;
import dingzhen.entity.sys.Operation;

/**
 *@author: wangq
 *@date: 2015-8-7上午09:01:02
 *@version:
 *@description：
 */
public interface OperationService extends BaseService<Operation> {
	public void deleteByMenuId(String menuId) throws Exception;
}