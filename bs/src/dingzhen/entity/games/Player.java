package dingzhen.entity.games;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RequestMapping;

import dingzhen.common.base.BaseEntity;
import dingzhen.entity.sys.User;

/**
 * @author wangqun
 * @date 2018年3月2日 下午3:46:15
 * @version 0.0.1
 * @description 运动员
 */
@RequestMapping("player")
public class Player extends BaseEntity implements Serializable {

	private String sex;
	private String realName;
	private String dept;
	private User user;
	private String id;
	private String disease;
	private String remarks;
	private String code;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	@Override
	public String toString() {
		return "Player [sex=" + sex + ", realName=" + realName + ", dept="
				+ dept + ", user=" + user + ", id=" + id + ", disease="
				+ disease + ", remarks=" + remarks + ", code=" + code + "]";
	}
	
}
