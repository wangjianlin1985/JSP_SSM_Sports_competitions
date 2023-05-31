package dingzhen.service.games;

import dingzhen.common.base.BaseService;
import dingzhen.entity.games.Player;

/**
 * @author wangqun
 * @date 2018年3月2日 下午3:49:14
 * @version 0.0.1
 * @description 
 */
public interface PlayerService extends BaseService<Player> {

	public Player findOneByUserid(String userid);
	
}
