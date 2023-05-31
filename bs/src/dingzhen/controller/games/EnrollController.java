package dingzhen.controller.games;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import dingzhen.entity.games.Grouping;
import dingzhen.entity.games.Player;
import dingzhen.entity.sys.User;
import dingzhen.service.games.EnrollService;
import dingzhen.service.games.EventsService;
import dingzhen.service.games.GroupingService;
import dingzhen.service.games.PlayerService;

/**
 * @author wangqun
 * @date 2018年3月3日 上午10:37:24
 * @version 0.0.1
 * @description 
 */
@Controller
@RequestMapping("enroll")
@SuppressWarnings("all")
public class EnrollController extends BaseController<Enroll> {
	
	@Autowired
	private EnrollService enrollService;
	@Autowired
	private PlayerService playerService;
	@Autowired
	private EventsService eventsService;
	@Autowired
	private GroupingService groupService;
	

	@RequestMapping("index")
	public String index(HttpServletRequest request){
		if(isSystemAdmin()){
			return "games/enrollIndex";
		} else {
			User user = (User) request.getSession().getAttribute("currentUser");
			Player player = playerService.findOneByUserid(user.getId());
			request.setAttribute("sex", player.getSex());
			return "games/enrollMy"; 
		}
	}
	
	
	@RequestMapping("enrollList")
	@ResponseBody
	public ResponseDate<Enroll> enrollList(HttpServletRequest request,HttpServletResponse response){
		ResponseDate<Enroll> rd = new ResponseDate<Enroll>();
		try {
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
			Enroll enroll = new Enroll();
			String eventsid = request.getParameter("eventsid");
			if(StringUtils.isNotEmpty(eventsid)){
				Events events = new Events();
				events.setId(eventsid);
				enroll.setEvents(events);
			}
			enroll.setPage((page-1)*rows);
			enroll.setRows(rows);
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
	
	
	
	@RequestMapping("enrollMyList")
	@ResponseBody
	public ResponseDate<Enroll> enrollMyList(HttpServletRequest request,HttpServletResponse response){
		ResponseDate<Enroll> rd = new ResponseDate<Enroll>();
		try {
			User user = (User) request.getSession().getAttribute("currentUser");
			Player player = playerService.findOneByUserid(user.getId());
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
			Enroll enroll = new Enroll();
			enroll.setPlayer(player);
			enroll.setPage((page-1)*rows);
			enroll.setRows(rows);
			List<Enroll> list = enrollService.findList(enroll);
			int total = enrollService.count(enroll);
			rd.setRows(list);
			rd.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rd;
	}
	
	@RequestMapping("addEnroll")
	@ResponseBody
	public ResponseDate addEnroll(HttpServletRequest request,HttpServletResponse response){
		ResponseDate rd = new ResponseDate();
		try {
			String eventsid = request.getParameter("eventsid");
			User user = (User) request.getSession().getAttribute("currentUser");
			Player player = playerService.findOneByUserid(user.getId());
			Map map = new HashMap();
			map.put("eventsid", eventsid);
			map.put("playerid", player.getId());
			int count = enrollService.checkExist(map);
			if(count>0){
				rd.setErrorMsg("您已经报名过该项目了！");
			} else {
				Enroll e = new Enroll();
				e.setId(get32UUID());
				e.setPlayer(player);
				Events events = new Events();
				events.setId(eventsid);
				e.setEvents(events);
				enrollService.add(e);
				rd.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rd.setErrorMsg("保存失败");
		}
		return rd;
	}
	
	
	// 分道分组判断
	@RequestMapping("searchCountPlayer")
	@ResponseBody
	public ResponseDate searchCountPlayer(HttpServletRequest request,HttpServletResponse response){
		ResponseDate rd = new ResponseDate();
		try {
			String eventsid = request.getParameter("eventsid");
			Events events = new Events();events.setId(eventsid);
			events = eventsService.findOne(events);
			String fenzu = events.getFenzu();
			if("否".equals(fenzu)){
				rd.setErrorMsg("该项目无需分组");
			} else {
				Enroll enroll = new Enroll();
				enroll.setEvents(events);
				int total = enrollService.count(enroll);
				rd.setTotal(total);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rd.setErrorMsg("操作失败");
		}
		return rd;
	}
	
	
	// 分组 
	@RequestMapping("splitGroup")
	@ResponseBody
	public ResponseDate splitGroup(HttpServletRequest request,HttpServletResponse response){
		ResponseDate rd = new ResponseDate();
		try {
			String eventsid = request.getParameter("eventsid");
			int playerPerGroup = Integer.parseInt(request.getParameter("playerPerGroup"));  //每组人数
			Events events = new Events();events.setId(eventsid);
			events = eventsService.findOne(events);
			Enroll enroll = new Enroll();
			enroll.setEvents(events);
			List<Enroll> list = enrollService.findList(enroll);
			int shang = 0;   // 商     分组数量
			int yushu = 0;   // 余数  最后一组人的数量
			if(list.size() % playerPerGroup == 0){
				shang = list.size() / playerPerGroup;
			} else {
				yushu = list.size() % playerPerGroup;
				shang = list.size() / playerPerGroup;
			}
			for(int i=1;i<=shang;i++){
				String z = "第"+i+"组";
				for(int j=1;j<=playerPerGroup;j++){
					String d = "第"+j+"号";
					Player p = list.get((i-1)*playerPerGroup + (j-1)).getPlayer();
					Grouping grouping = new Grouping();
					grouping.setId(get32UUID());
					grouping.setEvents(events);
					grouping.setPlayer(p);
					grouping.setName(z);
					grouping.setSort(d);
					groupService.add(grouping);
				}
			}
			if(yushu > 0){
				for(int i=0;i<yushu;i++){
					Player p = list.get(shang * playerPerGroup + i).getPlayer();
					System.out.println("第"+ (shang+1) + "组第  "+(i+1)+"号  " + p);
					Grouping grouping = new Grouping();
					grouping.setId(get32UUID());
					grouping.setEvents(events);
					grouping.setPlayer(p);
					grouping.setName("第"+(shang+1)+"组");
					grouping.setSort("第"+(i+1)+"号");
					groupService.add(grouping);
				}
			}
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setErrorMsg("操作失败");
		}
		return rd;
	}
	
	
	
	
	
	// 删除分组 
	@RequestMapping("deleteGroup")
	@ResponseBody
	public ResponseDate deleteGroup(HttpServletRequest request,HttpServletResponse response) {
		ResponseDate rd = new ResponseDate();
		try {
			String eventsid = request.getParameter("eventsid");
			Events events = new Events();
			events.setId(eventsid);
			Grouping grouping = new Grouping();
			grouping.setEvents(events);
			groupService.delete(grouping);
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setErrorMsg("操作失败");
		}
		return rd;
	}
	
	
	// 保存成绩
	@RequestMapping("reserveAchieve")
	@ResponseBody
	public ResponseDate reserveAchieve(HttpServletRequest request,HttpServletResponse response) {
		ResponseDate rd = new ResponseDate();
		try {
			String id = request.getParameter("id");
			String yusai = request.getParameter("yusai");
			String yscore = request.getParameter("yscore");
			String jscore = request.getParameter("jscore");
			String rtype = request.getParameter("rtype"); // 0越大越好 1越小越好
			String eventsid = request.getParameter("eventsid");
			Events a = new Events();
			a.setId(eventsid);
			Events events = eventsService.findOne(a); // 每次都从数据库查，获取的打破记录的值都是最新数据
			String record = events.getRecord();
			
			Enroll enroll = new Enroll();
			enroll.setId(id);
			if(StringUtils.isNotEmpty(yscore)){
				enroll.setYscore(yscore);
				enrollService.updateYScore(enroll); // 更新预赛成绩
				// 说明破记录了
				if(("0".equals(rtype)&&yscore.compareTo(record)>0) || ("1".equals(rtype)&&yscore.compareTo(record)<0)){
					enroll.setBreakrecord(yscore);
					enrollService.updateBreakrecord(enroll);
					// 更新比赛项目的记录
					events.setRecord(yscore);
					eventsService.updateRecord(events);
					rd.setOther("更新成绩成功，且该同学的"+yscore+"打破了之前的"+record+"成绩");
				}else {
					rd.setOther("更新成绩成功");
				}
			} 
			if(StringUtils.isNotEmpty(jscore)){
				enroll.setJscore(jscore);
				enrollService.updateJScore(enroll);
				
				// 说明破记录了
				if(("0".equals(rtype)&&jscore.compareTo(record)>0) || ("1".equals(rtype)&&jscore.compareTo(record)<0)){
					enroll.setBreakrecord(jscore);
					enrollService.updateBreakrecord(enroll);
					
					events.setRecord(jscore);
					eventsService.updateRecord(events);
					
					rd.setOther("更新成绩成功，且该同学的"+jscore+"打破了之前的"+record+"成绩");
				} else {
					rd.setOther("更新成绩成功");
				}
			} 
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setErrorMsg("操作失败");
		}
		return rd;
	}
	
	public static void main(String[] args) {
		String a = "00:04:23";
		String b = "00:02:23";
		System.out.println(a.compareTo(b));
	}
}
