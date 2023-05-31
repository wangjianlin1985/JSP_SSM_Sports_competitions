package dingzhen.service.impl.sys;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dingzhen.common.base.BaseServiceImpl;
import dingzhen.dao.sys.OperationDao;
import dingzhen.entity.sys.Operation;
import dingzhen.service.sys.OperationService;

/**
 *@author: wangq
 *@date: 2015-8-7上午09:01:44
 *@version:
 *@description：
 */
@Service("operationService")
public class OperationServiceImpl extends BaseServiceImpl<Operation> implements OperationService{
	
	@Autowired
	private OperationDao dao;

	public void deleteByMenuId(String menuId) throws Exception {
		dao.deleteByMenuId(menuId);
	}
	
}
