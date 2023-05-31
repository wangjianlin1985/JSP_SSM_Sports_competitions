package dingzhen.service.impl.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dingzhen.common.base.BaseServiceImpl;
import dingzhen.dao.games.EventsDao;
import dingzhen.entity.games.Events;
import dingzhen.service.games.EventsService;

/**
 * @author wangqun
 * @date 2018年3月2日 下午2:12:58
 * @version 0.0.1
 * @description 
 */
@Service("eventsService")
public class EventServiceImpl extends BaseServiceImpl<Events> implements EventsService {

	@Autowired
	private EventsDao dao;
	
	public void updateRecord(Events events) throws Exception {
		dao.updateRecord(events);
	}

}
