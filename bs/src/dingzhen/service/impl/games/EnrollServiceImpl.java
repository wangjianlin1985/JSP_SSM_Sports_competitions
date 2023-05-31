package dingzhen.service.impl.games;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dingzhen.common.base.BaseServiceImpl;
import dingzhen.dao.games.EnrollDao;
import dingzhen.entity.games.Enroll;
import dingzhen.service.games.EnrollService;


@Service("enrollService")
public class EnrollServiceImpl extends BaseServiceImpl<Enroll> implements EnrollService{

	@Autowired
	private EnrollDao dao;
	
	public void updateYScore(Enroll enroll) throws Exception {
		dao.updateYScore(enroll);
	}

	public void updateJScore(Enroll enroll) throws Exception {
		dao.updateJScore(enroll);
	}

	public void updateBreakrecord(Enroll enroll) throws Exception {
		dao.updateBreakrecord(enroll);
	}

	public int checkExist(Map map) throws Exception {
		return dao.checkExist(map);
	}

}
