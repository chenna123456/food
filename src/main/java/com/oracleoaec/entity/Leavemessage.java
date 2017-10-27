package com.oracleoaec.entity;
import java.util.Date;
/**
 * 留言实体类
 * @author 朱锦锐
 *
 */
public class Leavemessage {
	private Integer id;
	private String vipName;
	private String title;
	private Integer vipid;
	private String content;
	private String vipUrl;//头像路径
	private Date publishtime; //发表时间
	private String email;
	private String qq;
	private String homePage;  //个人主页
	private String moodUrl;  //个人头像url
	
	public Leavemessage() {
		super();
	}
	
	public Leavemessage(Integer id, String title, Integer vipid, 
			String content, String vipUrl, Date publishtime,
			String vipName,String email,String qq,String homePage,
			String moodUrl) {
		super();
		this.id = id;
		this.title = title;
		this.vipid = vipid;
		this.content = content;
		this.vipUrl = vipUrl;
		this.publishtime = publishtime;
		this.vipName=vipName;
		this.email=email;
		this.qq=qq;
		this.homePage=homePage;
		this.moodUrl=moodUrl;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getMoodUrl() {
		return moodUrl;
	}

	public void setMoodUrl(String moodUrl) {
		this.moodUrl = moodUrl;
	}

	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
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
	public Integer getVipid() {
		return vipid;
	}
	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVipUrl() {
		return vipUrl;
	}
	public void setVipUrl(String vipUrl) {
		this.vipUrl = vipUrl;
	}
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	@Override
	public String toString() {
		return "Leavemessage [id=" + id + ", vipName=" + vipName + ", title=" + title + ", vipid=" + vipid
				+ ", content=" + content + ", vipUrl=" + vipUrl + ", publishtime=" + publishtime + ", email=" + email
				+ ", qq=" + qq + ", homePage=" + homePage + ", moodUrl=" + moodUrl + "]";
	}
}