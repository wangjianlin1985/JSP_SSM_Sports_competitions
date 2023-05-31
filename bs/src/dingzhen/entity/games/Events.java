package dingzhen.entity.games;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import dingzhen.common.base.BaseEntity;


@Alias("events")
public class Events extends BaseEntity implements Serializable{

	/**
     */
    private static final long serialVersionUID = -837706637266235038L;
    private String id;
    private String name;
    private String sex;
    private String type;
    private String record;
    private String rtype;
    private String fenzu;
    private String yusai;
    private String unit;
    
    
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public String getFenzu() {
		return fenzu;
	}
	public void setFenzu(String fenzu) {
		this.fenzu = fenzu;
	}
	public String getYusai() {
		return yusai;
	}
	public void setYusai(String yusai) {
		this.yusai = yusai;
	}
    
    
}
