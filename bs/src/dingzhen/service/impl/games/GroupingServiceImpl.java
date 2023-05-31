package dingzhen.service.impl.games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dingzhen.common.base.BaseServiceImpl;
import dingzhen.dao.games.GroupingDao;
import dingzhen.entity.games.Grouping;
import dingzhen.service.games.GroupingService;

/**
 * @author wangqun
 * @date 2018年3月5日 上午10:36:46
 * @version 0.0.1
 * @description 
 */
@Service("groupingService")
public class GroupingServiceImpl extends BaseServiceImpl<Grouping> implements GroupingService{

	@Autowired
	private GroupingDao dao;
	
	public List<Grouping> findGroupingName(Grouping grouping) {
		return dao.findGroupingName(grouping);
	}

}
