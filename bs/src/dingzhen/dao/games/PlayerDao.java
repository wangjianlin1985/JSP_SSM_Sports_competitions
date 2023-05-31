package dingzhen.dao.games;

import org.springframework.stereotype.Repository;

import dingzhen.common.base.BaseDao;
import dingzhen.entity.games.Player;

/**
 * @author wangqun
 * @date 2018年3月2日 下午3:48:23
 * @version 0.0.1
 * @description 
 */
@Repository
public interface PlayerDao extends BaseDao<Player> {

	public Player findOneByUserid(String userid);
	
}
