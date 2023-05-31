package dingzhen.controller.games;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dingzhen.common.base.BaseController;
import dingzhen.common.base.ResponseDate;
import dingzhen.common.util.StringUtil;
import dingzhen.entity.games.Player;
import dingzhen.entity.sys.User;
import dingzhen.service.games.PlayerService;

/**
 * @author wangqun
 * @date 2018年3月2日 下午4:03:35
 * @version 0.0.1
 * @description 
 */
@RequestMapping("player")
@Controller
public class PlayerController extends BaseController<Player>{
	
	@Autowired
	private PlayerService playerService;
	
	
	@RequestMapping("playerIndex")
	public String playerIndex(){
		return "games/playerList";
	}
	
	
	@RequestMapping("playerList")
	@ResponseBody
	public ResponseDate<Player> playerList(HttpServletRequest request,HttpServletResponse response){
		ResponseDate<Player> rd = new ResponseDate<Player>();
		try {
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
			Player player = new Player();
			player.setSex(request.getParameter("sex"));
			player.setKeyword(request.getParameter("keyword"));
			player.setPage((page-1)*rows);
			player.setRows(rows);
			List<Player> list = playerService.findList(player);
			int total = playerService.count(player);
			rd.setRows(list);
			rd.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setSuccess(false);
			rd.setErrorMsg("查询失败");
		}
		return rd;
	}
	
	

	// 个人基本信息
	@RequestMapping("playerInfo")
	public String myinfo(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("currentUser");
		String id = user.getId();
		Player player = playerService.findOneByUserid(id);
		if(player == null){
			player = new Player();
			player.setUser(user); // 防止为空
		}
		request.setAttribute("player", player);
		return "games/playerInfo";
	}
	
	// 保存或者修改个人信息
	@RequestMapping("reservePlayer")
	@ResponseBody
	public ResponseDate<Player> reservePlayer(HttpServletRequest request,HttpServletResponse response,Player player){
		String id = request.getParameter("id");
		ResponseDate<Player> rd = new ResponseDate<Player>();
		try {
			if (StringUtil.isNotEmpty(id)) {   // id不为空 说明是修改
				player.setId(id);
				playerService.update(player);
			}else {   // 添加
				player.setId(get32UUID());
				User user = (User) request.getSession().getAttribute("currentUser");
				player.setUser(user);
				playerService.add(player);
			}
			rd.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			rd.setSuccess(false);
			rd.setErrorMsg(OPERATION_FAIL);
		}
		return rd;
	}
	
}
