package dingzhen.controller.games;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dingzhen.common.base.BaseController;
import dingzhen.common.base.ResponseDate;
import dingzhen.entity.games.Enroll;
import dingzhen.entity.games.Events;
import dingzhen.service.games.EnrollService;
import dingzhen.service.games.EventsService;
import dingzhen.service.games.GroupingService;
import dingzhen.service.games.PlayerService;

/**
 * @author wangqun
 * @date 2018年3月5日 下午5:05:52
 * @version 0.0.1
 * @description 
 */
@Controller
@RequestMapping("achieve")
@SuppressWarnings("all")
public class AchieveController extends BaseController{

	@Autowired
	private EnrollService enrollService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private EventsService eventsService;
	@Autowired
	private GroupingService groupService;
	
	@RequestMapping("index")
	public String index(){
		return "games/achieve";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public ResponseDate<Enroll> enrollList(HttpServletRequest request,HttpServletResponse response){
		ResponseDate<Enroll> rd = new ResponseDate<Enroll>();
		
		try {
			String a  = request.getParameter("qianjiming");
			if(StringUtils.isEmpty(a)){
				a = "3";
			}
			int qianjiming = Integer.parseInt(a);
			Enroll enroll = new Enroll();
			String eventsid = request.getParameter("eventsid");
			enroll.setBreakrecord(request.getParameter("breakrecord"));
			if(StringUtils.isNotEmpty(eventsid)){
				Events events = new Events();
				events.setId(eventsid);
				events = eventsService.findOne(events);
				enroll.setEvents(events);
			}
			enroll.setPage(0);
			enroll.setRows(qianjiming);
			enroll.setKeyword(request.getParameter("keyword"));
			List<Enroll> list = enrollService.findList(enroll);
			int total = enrollService.count(enroll);
			rd.setRows(list);
			rd.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rd;
	}
	
	
}
