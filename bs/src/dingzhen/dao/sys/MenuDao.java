package dingzhen.dao.sys;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import dingzhen.common.base.BaseDao;
import dingzhen.entity.sys.Menu;

/**
 *@author: wangq
 *@date: 2015-5-18下午04:31:26
 *@version:
 *@description：
 */
@Repository
public interface MenuDao extends BaseDao<Menu>{
	
	@SuppressWarnings({"rawtypes" })
	public abstract List<Menu> menuTree(Map map) throws Exception;
}
