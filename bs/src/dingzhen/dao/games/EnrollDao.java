package dingzhen.dao.games;

import java.util.Map;

import org.springframework.stereotype.Repository;

import dingzhen.common.base.BaseDao;
import dingzhen.entity.games.Enroll;

/**
 * @author wangqun
 * @date 2018年3月3日 上午10:07:18
 * @version 0.0.1
 * @description 
 */
@Repository
public interface EnrollDao extends BaseDao<Enroll>{

	public void updateYScore(Enroll enroll) throws Exception;
	
	public void updateJScore(Enroll enroll) throws Exception;
	
	public void updateBreakrecord(Enroll enroll) throws Exception;
	
	// 该人在该项目是否已经报过名了
	public int checkExist(Map map) throws Exception;
	
}
