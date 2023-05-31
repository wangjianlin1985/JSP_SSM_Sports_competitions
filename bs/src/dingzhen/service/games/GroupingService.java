package dingzhen.service.games;

import java.util.List;

import dingzhen.common.base.BaseService;
import dingzhen.entity.games.Grouping;

/**
 * @author wangqun
 * @date 2018年3月5日 上午10:36:27
 * @version 0.0.1
 * @description 
 */
public interface GroupingService extends BaseService<Grouping> {
	public List<Grouping> findGroupingName(Grouping grouping);
}
