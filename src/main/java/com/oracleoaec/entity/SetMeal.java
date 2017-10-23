package com.oracleoaec.entity;

public class SetMeal {
	private Integer id;
	private String name;// 套餐名称
	private Integer meatNumber;// 荤菜数量
	private Integer vegetableNumber;// 素菜数量

	public SetMeal() {
	}

	public SetMeal(Integer id, String name, Integer meatNumber, Integer vegetableNumber) {
		this.id = id;
		this.name = name;
		this.meatNumber = meatNumber;
		this.vegetableNumber = vegetableNumber;
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

	public Integer getMeatNumber() {
		return meatNumber;
	}

	public void setMeatNumber(Integer meatNumber) {
		this.meatNumber = meatNumber;
	}

	public Integer getVegetableNumber() {
		return vegetableNumber;
	}

	public void setVegetableNumber(Integer vegetableNumber) {
		this.vegetableNumber = vegetableNumber;
	}

	public String toString() {
		return "SetMeal [id=" + id + ", name=" + name + ", meatNumber=" + meatNumber + ", vegetableNumber="
				+ vegetableNumber + "]";
	}

}
