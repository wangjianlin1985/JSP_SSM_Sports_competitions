package dingzhen.dao.games;

import java.util.List;

import org.springframework.stereotype.Repository;

import dingzhen.common.base.BaseDao;
import dingzhen.entity.games.Grouping;

/**
 * @author wangqun
 * @date 2018年3月5日 上午10:35:56
 * @version 0.0.1
 * @description 
 */
@Repository
public interface GroupingDao extends BaseDao<Grouping>{
	
	// 根据eventsid查找该项目下面的所有分组
	public List<Grouping> findGroupingName(Grouping grouping);

}
