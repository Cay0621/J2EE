package org.com.cay.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;


public class Cost implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//ID
	private String name;//NAME
	private Integer baseDuration;//BASE_DURATION
	private Float baseCost;//BASE_COST
	private Float unitCost;//UNIT_COST
	private String status;//STATUS
	private String descr;//DESCR
	private Date createTime;//CREATETIME
	private Date startTime;//STARTTIME
	
	public Cost(){
		super();
	}
	
	public Cost(Map<String, Object> map){
		this.id = (int)map.get("ID");
		this.name = (String)map.get("NAME");
		this.baseDuration = (int)map.get("BASE_DURATION");
		this.baseCost = (float)map.get("BASE_COST");
		this.unitCost = (float)map.get("UNIT_COST");
		this.status = (String)map.get("STATUS");
		this.descr = (String)map.get("DESCR");
		this.createTime = (Date)map.get("CREATETIME");
		if(map.get("STARTTIME") != null)
			this.startTime = (Date)map.get("STARTTIME");
	}
	
	public Cost(Integer id, String name, Integer baseDuration, Float baseCost,
			Float unitCost, String status, String descr, Date createTime,
			Date startTime) {
		super();
		this.id = id;
		this.name = name;
		this.baseDuration = baseDuration;
		this.baseCost = baseCost;
		this.unitCost = unitCost;
		this.status = status;
		this.descr = descr;
		this.createTime = createTime;
		this.startTime = startTime;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Float getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Float baseCost) {
		this.baseCost = baseCost;
	}
	public Float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  id + "," + name
				+ "," + baseDuration + "," + baseCost + ","
				+ unitCost	+ "," + status + "," + descr
				+ "," + createTime + "," + startTime;
	}
}
