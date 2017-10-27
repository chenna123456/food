package com.oracleoaec.entity;

import java.util.Date;
/**
 * 投诉实体类
 * @author 朱锦锐
 *
 */
public class Complaint {
	private Integer id;
	private String title;
	private String content;
	private String complaintName;
	private Integer vipId;
	private String gender;
	private String address;
	private Date complaintDate;

	public Complaint() {
	}

	public Complaint(Integer id, String title, String content, String complaintName, Integer vipId, String gender,
			String address, Date complaintDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.complaintName = complaintName;
		this.vipId = vipId;
		this.gender = gender;
		this.address = address;
		this.complaintDate = complaintDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComplaintName() {
		return complaintName;
	}

	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String toString() {
		return "Complaint [id=" + id + ", title=" + title + ", content=" + content + ", complaintName=" + complaintName
				+ ", vipId=" + vipId + ", gender=" + gender + ", address=" + address + ", complaintDate="
				+ complaintDate + "]";
	}

	

}
