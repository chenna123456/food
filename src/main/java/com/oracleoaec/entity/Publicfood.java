package com.oracleoaec.entity;

import java.util.Date;

public class Publicfood {
	private Integer id;
	private Date pulicdate;
	private String foodname;
	private String src;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getPulicdate() {
		return pulicdate;
	}
	public void setPulicdate(Date pulicdate) {
		this.pulicdate = pulicdate;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	@Override
	public String toString() {
		return "Publicfood [id=" + id + ", pulicdate=" + pulicdate + ", foodname=" + foodname + ", src=" + src + "]";
	}

}
