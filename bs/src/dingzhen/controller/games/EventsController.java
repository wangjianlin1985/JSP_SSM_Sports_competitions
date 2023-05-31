package dingzhen.controller.games;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.poi.hssf.record.formula.functions.Even;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dingzhen.common.base.BaseController;
import dingzhen.common.base.ResponseDate;
import dingzhen.common.util.StringUtil;
import dingzhen.common.util.WriterUtil;
import dingzhen.entity.games.Events;
import dingzhen.service.games.EventsService;

/**
 * @author wangqun
 * @date 2018年3月2日 下午2:30:32
 * @version 0.0.1
 * @description 
 */
@RequestMapping("events")
@Controller
@SuppressWarnings("rawtypes")
public class EventsController extends BaseController<Events>{
	
	@Autowired
	private EventsService eventsService;
	
	
	@RequestMapping("eventsIndex")
	public String eventsIndex(){
		return "games/event";
	}
	
	
	
	@RequestMapping("eventsList")
	@ResponseBody
	public ResponseDate<Events> eventList(HttpServletRequest request,HttpServletResponse response){
		ResponseDate<Events> rd = new ResponseDate<Events>();
		try {
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
			Events events = new Events();
			events.setFenzu(request.getParameter("fenzu"));
			events.setName(request.getParameter("name"));
			events.setSex(request.getParameter("sex"));
			events.setType(request.getParameter("type"));
			events.setYusai(request.getParameter("yusai"));
			events.setPage((page-1)*rows);
			events.setRows(rows);
			List<Events> list = eventsService.findList(events);
			int total = eventsService.count(events);
			rd.setRows(list);
			rd.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setSuccess(false);
			rd.setErrorMsg("查询失败");
		}
		return rd;
	}
	
	
	
	// 新增或修改
	@RequestMapping("reserveEvents")
	@ResponseBody
	public ResponseDate reserveEvents(HttpServletRequest request,Events events,HttpServletResponse response){
		String id = request.getParameter("id");
		ResponseDate rd = new ResponseDate();
		try {
			if (StringUtil.isNotEmpty(id)) {   // id不为空 说明是修改
				events.setId(id);
				eventsService.update(events);
			}else {   // 添加
				events.setId(get32UUID());
				eventsService.add(events);
			}
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setSuccess(true);
			rd.setErrorMsg(OPERATION_FAIL);
		}
		return rd;
	}
	
	
	@RequestMapping("deleteEvents")
	@ResponseBody
	public ResponseDate deleteEvents(HttpServletRequest request,HttpServletResponse response){
		ResponseDate rd = new ResponseDate();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				Events events = new Events();
				events.setId(id);
				eventsService.delete(events);
			}
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除赛事错误",e);
			rd.setErrorMsg(DELETE_FAIL);
		}
		return rd;
	}

	
	@RequestMapping("eventsCombobox")
	public void eventsCombobox(HttpServletRequest request,HttpServletResponse response){
		try {
			JSONArray jsonArray=new JSONArray();
			String sex = request.getParameter("sex");
			String fenzu = request.getParameter("fenzu");
			Events events = new Events();
			events.setSex(sex);
			events.setFenzu(fenzu);
			List<Events> list = eventsService.findList(events);
			jsonArray.addAll(list);
			WriterUtil.write(response, jsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
