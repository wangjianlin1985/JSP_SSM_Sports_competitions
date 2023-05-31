package dingzhen.common.base;

import java.util.List;


/**
 * time    2017-1-10 上午8:52:34
 * author  wangqun
 * description easyui json展示
 * version 
 */
public class ResponseDate<T> {
	
	private int total;
	private List<T> rows;
	private boolean success;  //是否成功 
	private String errorMsg;  //错误信息
	private String successMsg;  // 成功信息
	private String other;      //其他
	
	
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
