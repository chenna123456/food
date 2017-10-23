package com.oracleoaec.entity;
import java.util.Date;
/**
 * 留言实体类
 * @author 朱锦锐
 *
 */
public class Leavemessage {
	private Integer id;
	private String title;
	private Integer vipid;
	private String content;
	private String vipUrl;//图片路径
	private Date publishtime;
	public Leavemessage() {
		super();
	}
	public Leavemessage(Integer id, String title, Integer vipid, String content, String vipUrl, Date publishtime) {
		super();
		this.id = id;
		this.title = title;
		this.vipid = vipid;
		this.content = content;
		this.vipUrl = vipUrl;
		this.publishtime = publishtime;
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
	public String toString() {
		return "Leavemessage [id=" + id + ", title=" + title + ", vipid=" + vipid + ", content=" + content + ", vipUrl="
				+ vipUrl + ", publishtime=" + publishtime + "]";
	}
}