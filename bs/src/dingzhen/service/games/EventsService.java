package dingzhen.service.games;

import dingzhen.common.base.BaseService;
import dingzhen.entity.games.Events;

/**
 *@author: wangq
 *@date: 2015-5-18下午04:57:31
 *@version:
 *@description：
 */
public interface EventsService  extends BaseService<Events> {
	// 更新记录
	public void updateRecord(Events events) throws Exception;

}
