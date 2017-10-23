package com.oracleoaec.entity;

import java.math.BigDecimal;

/**
 * 自选食物实体类
 * @author 朱锦锐
 *
 */
public class Optionalfood {
	private Integer id;
	private String foodName;
	private String type;
	private BigDecimal price;
	private Integer point;
	private String ingredients;
	private String flavor;
	private Integer count;
	private String src;
	private String describe;
	public Optionalfood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Optionalfood(Integer id, String foodName, String type, BigDecimal price, Integer point, String ingredients,
			String flavor, Integer count, String src, String describe) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.type = type;
		this.price = price;
		this.point = point;
		this.ingredients = ingredients;
		this.flavor = flavor;
		this.count = count;
		this.src = src;
		this.describe = describe;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
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
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "Optionalfood [id=" + id + ", foodName=" + foodName + ", type=" + type + ", price=" + price + ", point="
				+ point + ", ingredients=" + ingredients + ", flavor=" + flavor + ", count=" + count + ", src=" + src
				+ ", describe=" + describe + "]";
	}
}
