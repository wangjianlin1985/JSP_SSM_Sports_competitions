package dingzhen.dao.games;

import org.springframework.stereotype.Repository;

import dingzhen.common.base.BaseDao;
import dingzhen.entity.games.Events;

/**
 * @author wangqun
 * @date 2018年3月2日 下午2:11:46
 * @version 0.0.1
 * @description 
 */
@Repository
public interface EventsDao extends BaseDao<Events>{
	
	// 更新记录
	public void updateRecord(Events events) throws Exception;

}
