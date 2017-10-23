package com.oracleoaec.entity;
/**
 * 组合套餐实体类
 * @author 朱锦锐
 *
 */
public class Combinationfood {
	public Integer id;
	public String foodName;
	public String type;
	public Combinationfood() {
		super();
	}
	public Combinationfood(Integer id, String foodName, String type) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Combinationfood [id=" + id + ", foodName=" + foodName + ", type=" + type + "]";
	}
}
