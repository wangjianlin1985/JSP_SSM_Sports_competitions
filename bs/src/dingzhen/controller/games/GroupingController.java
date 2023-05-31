package dingzhen.controller.games;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import dingzhen.common.base.BaseController;
import dingzhen.common.base.ResponseDate;
import dingzhen.common.util.WriterUtil;
import dingzhen.entity.games.Events;
import dingzhen.entity.games.Grouping;
import dingzhen.service.games.GroupingService;

/**
 * @author wangqun
 * @date 2018年3月5日 上午11:00:29
 * @version 0.0.1
 * @description 
 */
@Controller
@RequestMapping("grouping")
@SuppressWarnings("all")
public class GroupingController extends BaseController<Grouping>{

	@Autowired
	private GroupingService groupingService;
	
	@RequestMapping("index")
	public String index(){
		return "games/grouping";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public ResponseDate<Grouping> list(HttpServletRequest request,HttpServletResponse response){
		ResponseDate<Grouping> rd = new ResponseDate<Grouping>();
		try {
			String eventsid = request.getParameter("eventsid");
			String name = request.getParameter("name");
			Grouping grouping = new Grouping();
			grouping.setName(name);
			Events events = new Events();
			events.setId(eventsid);
			grouping.setEvents(events);
			List<Grouping> list = groupingService.findList(grouping);
			int total = groupingService.count(grouping);
			rd.setRows(list);
			rd.setTotal(total);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rd;
	}
	
	
	@RequestMapping("loadGrouping")
	public void loadGrouping(HttpServletRequest request,HttpServletResponse response){
		try {
			JSONArray array = new JSONArray();
			String eventsid = request.getParameter("eventsid");
			Events events = new Events();events.setId(eventsid);
			Grouping g = new Grouping();
			g.setEvents(events);
			List<Grouping> list = groupingService.findGroupingName(g);
			array.addAll(list);
			WriterUtil.write(response, array.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
