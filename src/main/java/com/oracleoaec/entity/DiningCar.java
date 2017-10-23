package com.oracleoaec.entity;

import java.math.BigDecimal;

/**
 * 餐车实体类
 * @author 陈娜
 *
 */
public class DiningCar {
	private Integer id;
	private Integer vipid;
	private String foodName;
	private BigDecimal price;
	private Integer number;
	private BigDecimal subtotal;// 对应食物的price*number

	public DiningCar() {
	}

	public DiningCar(Integer id, Integer vipid, String foodName, BigDecimal price, Integer number, BigDecimal subtotal) {
		super();
		this.id = id;
		this.vipid = vipid;
		this.foodName = foodName;
		this.price = price;
		this.number = number;
		this.subtotal = subtotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVipid() {
		return vipid;
	}

	public void setVipid(Integer vipid) {
		this.vipid = vipid;
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

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public String toString() {
		return "DiningCar [id=" + id + ", vipid=" + vipid + ", foodName=" + foodName + ", price=" + price + ", number="
				+ number + ", subtotal=" + subtotal + "]";
	}

}
