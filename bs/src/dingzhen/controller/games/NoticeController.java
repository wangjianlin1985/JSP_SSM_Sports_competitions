package dingzhen.controller.games;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

import dingzhen.common.base.BaseController;
import dingzhen.common.base.ResponseDate;
import dingzhen.common.util.StringUtil;
import dingzhen.common.util.WriterUtil;
import dingzhen.entity.games.Notice;
import dingzhen.service.games.NoticeService;

/**
 * @author wangqun
 * @date 2018年3月5日 下午6:09:12
 * @version 0.0.1
 * @description 
 */

@RequestMapping("notice")
@Controller
@SuppressWarnings("rawtypes")
public class NoticeController extends BaseController<Notice>{
	
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("index")
	public String noticeIndex(){
		return "games/notice";
	}
	
	@RequestMapping("findOne")
	public String findOne(HttpServletRequest request){
		try {
			String id = request.getParameter("id");
			Notice n = new Notice();
			n.setId(id);
			Notice notice = noticeService.findOne(n);
			System.out.println(notice.getTime());
			request.setAttribute("notice", notice);
			
		} catch (Exception e) {

		}
		return "games/noticeView";
	}
	
	@RequestMapping("findOneById")
	public void findOneById(HttpServletRequest request,HttpServletResponse response){
		try {
			String id = request.getParameter("id");
			Notice n = new Notice();
			n.setId(id);
			Notice notice = noticeService.findOne(n);
			JSONObject o = new JSONObject();
			o.put("notice", notice);
			WriterUtil.write(response, o.toString());
		} catch (Exception e) {

		}
	}
	
	
	@RequestMapping("noticeList")
	@ResponseBody
	public ResponseDate<Notice> eventList(HttpServletRequest request,HttpServletResponse response){
		ResponseDate<Notice> rd = new ResponseDate<Notice>();
		try {
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
			Notice notice = new Notice();
			notice.setTitle(request.getParameter("title"));
			notice.setPage((page-1)*rows);
			notice.setRows(rows);
			List<Notice> list = noticeService.findList(notice);
			int total = noticeService.count(notice);
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
	@RequestMapping("reserveNotice")
	@ResponseBody
	public ResponseDate reserveNotice(HttpServletRequest request,Notice notice,HttpServletResponse response){
		String id = request.getParameter("id");
		ResponseDate rd = new ResponseDate();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		notice.setTime(time);
		try {
			if (StringUtil.isNotEmpty(id)) {   // id不为空 说明是修改
				notice.setId(id);
				noticeService.update(notice);
			}else {   // 添加
				notice.setId(get32UUID());
				noticeService.add(notice);
			}
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setSuccess(true);
			rd.setErrorMsg(OPERATION_FAIL);
		}
		return rd;
	}
	
	
	@RequestMapping("deleteNotice")
	@ResponseBody
	public ResponseDate deleteNotice(HttpServletRequest request,HttpServletResponse response){
		ResponseDate rd = new ResponseDate();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				Notice notice = new Notice();
				notice.setId(id);
				noticeService.delete(notice);
			}
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setErrorMsg(DELETE_FAIL);
		}
		return rd;
	}

	
	
}
