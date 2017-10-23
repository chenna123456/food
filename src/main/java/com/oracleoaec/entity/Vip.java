package com.oracleoaec.entity;

import java.math.BigDecimal;

/**
 * vip实体类
 * @author 朱锦锐
 *
 */
public class Vip {
	private Integer id;
	private String userName;
	private String pwd;
	private String address;
	private Integer point;
	private String phone;
	private BigDecimal money;
	private String headImage;
	public Vip() {
		super();
	}
	
	public Vip(Integer id, String userName, String pwd, 
			String address, Integer point, String phone, BigDecimal money,
			String headImage) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.address = address;
		this.point = point;
		this.phone = phone;
		this.money = money;
		this.headImage = headImage;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	@Override
	public String toString() {
		return "Vip [id=" + id + ", userName=" + userName + ", pwd=" + pwd + ", address=" + address + ", point=" + point
				+ ", phone=" + phone + ", money=" + money + ", headImage=" + headImage + "]";
	}
}
