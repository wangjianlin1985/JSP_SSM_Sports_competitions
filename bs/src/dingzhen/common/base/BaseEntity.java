package dingzhen.common.base;
/**
 *@author: wangq
 *@date: 2015-5-18上午10:15:10
 *@version:
 *@description：查询搜索用
 */
public class BaseEntity {
	private Integer page;  // 当前页  
	private Integer rows;  // 每页条数
	private String start;  // 开始时间
	private String end;    // 结束时间
	private String searchParamA; // 查询条件A
	private String searchParamB; // 查询条件B
	private String keyword;// 查询条件关键字
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchParamA() {
		return searchParamA;
	}
	public void setSearchParamA(String searchParamA) {
		this.searchParamA = searchParamA;
	}
	public String getSearchParamB() {
		return searchParamB;
	}
	public void setSearchParamB(String searchParamB) {
		this.searchParamB = searchParamB;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
