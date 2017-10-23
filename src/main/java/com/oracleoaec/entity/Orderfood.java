package com.oracleoaec.entity;

import java.math.BigDecimal;

/**
 * 订单餐品详情实体类
 * 
 * @author 朱锦锐
 *
 */
public class Orderfood {
	private Integer id;
	private String orderNo;
	private String foodName;
	private BigDecimal price;
	private Integer number;
	private BigDecimal subtatol;

	public Orderfood() {
		super();
	}

	public Orderfood(Integer id, String orderNo, String foodName, BigDecimal price, Integer number, BigDecimal subtatol) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.foodName = foodName;
		this.price = price;
		this.number = number;
		this.subtatol = subtatol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BigDecimal getSubtatol() {
		return subtatol;
	}

	public void setSubtatol(BigDecimal subtatol) {
		this.subtatol = subtatol;
	}

	public String toString() {
		return "Orderfood [id=" + id + ", orderNo=" + orderNo + ", foodName=" + foodName + ", price=" + price
				+ ", number=" + number + ", subtatol=" + subtatol + "]";
	}
	
}
