package com.oracleoaec.entity;
import java.util.Date;
/**
 * 文章用户评论实体类
 * @author 朱锦锐
 *
 */
public class Vipcomment {
	private Integer id;
	private Integer articleID; 
	private String aTitle;
	private String vipname;
	private String content;  
	private Date leaveTime;
	public Vipcomment() {
	}
	public Vipcomment(String aTitle, Integer id, Integer articleID, String vipname, String content, Date leaveTime) {
		super();
		this.id = id;
		this.articleID = articleID;
		this.vipname = vipname;
		this.content = content;
		this.leaveTime = leaveTime;
		this.aTitle = aTitle;
	}
	
	public Integer getArticleID() {
		return articleID;
	}
	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getVipname() {
		return vipname;
	}
	public void setVipname(String vipname) {
		this.vipname = vipname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	@Override
	public String toString() {
		return "Vipcomment [id=" + id + ", articleID=" + articleID + ", aTitle=" + aTitle + ", vipname=" + vipname
				+ ", content=" + content + ", leaveTime=" + leaveTime + "]";
	}
}
