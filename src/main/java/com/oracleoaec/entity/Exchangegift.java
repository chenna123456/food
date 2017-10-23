package com.oracleoaec.entity;

/**
 * 积分兑换实体类
 * 
 * @author 陈娜
 *
 */
public class Exchangegift {
	private Integer id;
	private String name;
	private String type;//赠品分类
	private String specifications;// 赠品规格
	private String model;// 赠品型号
	private String describe;// 赠品简介
	private Integer exchangepoint;
	private Integer exchangetimes;
	private Integer count;
	private String src;//图片路径

	public Exchangegift() {
	}

	public Exchangegift(Integer id, String name, String type, String specifications, String model, String describe,
			Integer exchangepoint, Integer exchangetimes, Integer count, String src) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.specifications = specifications;
		this.model = model;
		this.describe = describe;
		this.exchangepoint = exchangepoint;
		this.exchangetimes = exchangetimes;
		this.count = count;
		this.src = src;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getExchangepoint() {
		return exchangepoint;
	}

	public void setExchangepoint(Integer exchangepoint) {
		this.exchangepoint = exchangepoint;
	}

	public Integer getExchangetimes() {
		return exchangetimes;
	}

	public void setExchangetimes(Integer exchangetimes) {
		this.exchangetimes = exchangetimes;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String toString() {
		return "Exchangegift [id=" + id + ", name=" + name + ", type=" + type + ", specifications=" + specifications
				+ ", model=" + model + ", describe=" + describe + ", exchangepoint=" + exchangepoint
				+ ", exchangetimes=" + exchangetimes + ", count=" + count + ", src=" + src + "]";
	}


	
}
