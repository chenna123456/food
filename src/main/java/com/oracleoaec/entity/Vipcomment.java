package com.oracleoaec.entity;
import java.util.Date;
/**
 * 文章用户评论实体类
 * @author 朱锦锐
 *
 */
public class Vipcomment {
	private Integer id;
	private Integer artcialId;
	private String vipname;
	private String content;
	private Date leaveTime;
	public Vipcomment() {
	}
	public Vipcomment(Integer id, Integer artcialId, String vipname, String content, Date leaveTime) {
		super();
		this.id = id;
		this.artcialId = artcialId;
		this.vipname = vipname;
		this.content = content;
		this.leaveTime = leaveTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArtcialId() {
		return artcialId;
	}
	public void setArtcialId(Integer artcialId) {
		this.artcialId = artcialId;
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
		return "Vipcomment [id=" + id + ", artcialId=" + artcialId + ", vipname=" + vipname + ", content=" + content
				+ ", leaveTime=" + leaveTime + "]";
	}
}
