package dingzhen.service.impl.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dingzhen.common.base.BaseServiceImpl;
import dingzhen.dao.games.PlayerDao;
import dingzhen.entity.games.Player;
import dingzhen.service.games.PlayerService;

/**
 * @author wangqun
 * @date 2018年3月2日 下午3:49:58
 * @version 0.0.1
 * @description 
 */
@Service("playerService")
public class PlayerServiceImpl extends BaseServiceImpl<Player> implements PlayerService{

	@Autowired
	private PlayerDao dao;
	
	public Player findOneByUserid(String userid) {
		return dao.findOneByUserid(userid);
	}

}
