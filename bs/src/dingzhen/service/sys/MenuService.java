package dingzhen.service.sys;

import java.util.List;
import java.util.Map;

import dingzhen.common.base.BaseService;
import dingzhen.entity.sys.Menu;


/**
 *@author: wangq
 *@date: 2015-5-18下午04:32:47
 *@version:
 *@description：
 */
public interface MenuService extends BaseService<Menu>{

	@SuppressWarnings("rawtypes")
	public List<Menu> menuTree(Map map) throws Exception;

}
