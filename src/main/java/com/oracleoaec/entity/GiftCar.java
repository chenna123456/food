package com.oracleoaec.entity;

import java.util.Date;

/**
 * 礼品车表
 * 
 * @author 陈娜
 *
 */
public class GiftCar {
	private Integer id;
	private Integer vipId;
	private Integer gitfId;
	private Integer number;
	private Date exchangeDate;//兑换时间

	public GiftCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiftCar(Integer id, Integer vipId, Integer gitfId, Integer number, Date exchangeDate) {
		super();
		this.id = id;
		this.vipId = vipId;
		this.gitfId = gitfId;
		this.number = number;
		this.exchangeDate = exchangeDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public Integer getGitfId() {
		return gitfId;
	}

	public void setGitfId(Integer gitfId) {
		this.gitfId = gitfId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public String toString() {
		return "GiftCar [id=" + id + ", vipId=" + vipId + ", gitfId=" + gitfId + ", number=" + number
				+ ", exchangeDate=" + exchangeDate + "]";
	}


}
