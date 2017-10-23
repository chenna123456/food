package com.oracleoaec.entity;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 订单详情类
 * @author 朱锦锐
 *
 */
public class Orderlistinfo {
	private Integer id;
	private String orderNo;
	private Integer vipId;
	private String vipName;
	private String address;
	private String phone;
	private Date publishTime;
	private String state;
	private Date paymentTime;
	private BigDecimal totalPrice;
	public Orderlistinfo() {
		super();
	}
	public Orderlistinfo(Integer id, String orderNo, Integer vipId, String vipName, String address, String phone,
			Date publishTime, String state, Date paymentTime, BigDecimal totalPrice) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.vipId = vipId;
		this.vipName = vipName;
		this.address = address;
		this.phone = phone;
		this.publishTime = publishTime;
		this.state = state;
		this.paymentTime = paymentTime;
		this.totalPrice = totalPrice;
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
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String toString() {
		return "Orderlistinfo [id=" + id + ", orderNo=" + orderNo + ", vipId=" + vipId + ", vipName=" + vipName
				+ ", address=" + address + ", phone=" + phone + ", publishTime=" + publishTime + ", state=" + state
				+ ", paymentTime=" + paymentTime + ", totalPrice=" + totalPrice + "]";
	}
	
}
