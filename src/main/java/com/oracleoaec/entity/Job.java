package com.oracleoaec.entity;

import java.math.BigDecimal;

public class Job {
	private Integer id;
	private String name;
	private String address;
	private Integer number;
	private BigDecimal monery;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(Integer id, String name, String address, Integer number, BigDecimal monery) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.monery = monery;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public BigDecimal getMonery() {
		return monery;
	}
	public void setMonery(BigDecimal monery) {
		this.monery = monery;
	}
	
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", address=" + address + ", number=" + number + ", monery=" + monery
				+ "]";
	}
	
	
	
}
