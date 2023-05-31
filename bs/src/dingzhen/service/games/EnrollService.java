package dingzhen.service.games;

import java.util.Map;

import dingzhen.common.base.BaseService;
import dingzhen.entity.games.Enroll;

/**
 * @author wangqun
 * @date 2018年3月3日 上午10:07:50
 * @version 0.0.1
 * @description 
 */
public interface EnrollService extends BaseService<Enroll> {

	public void updateYScore(Enroll enroll) throws Exception;
	
	public void updateJScore(Enroll enroll) throws Exception;
	
	public void updateBreakrecord(Enroll enroll) throws Exception;
	
	public int checkExist(Map map) throws Exception;
	
}
