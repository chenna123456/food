package com.oracleoaec.entity;
import java.util.Date;
/**
 * 文章实体类
 * @author 朱锦锐
 *
 */
public class Article {
	private Integer id;
	/**
	 * 文章标题
	 */
	private String title;
	private String type;
	private String writer;
	private Date publishtime;
	private String content;
	private Integer commentCount;//评论量
	private Integer Browsingamount;
	private Integer supportNum;
	private Integer opposeNum;
	public Article() {
	}
	public Article(Integer id, String title, String type, String writer, Date publishtime, String content,
			Integer commentCount, Integer browsingamount, Integer supportNum, Integer opposeNum) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.writer = writer;
		this.publishtime = publishtime;
		this.content = content;
		this.commentCount = commentCount;
		Browsingamount = browsingamount;
		this.supportNum = supportNum;
		this.opposeNum = opposeNum;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getBrowsingamount() {
		return Browsingamount;
	}
	public void setBrowsingamount(Integer browsingamount) {
		Browsingamount = browsingamount;
	}
	public Integer getSupportNum() {
		return supportNum;
	}
	public void setSupportNum(Integer supportNum) {
		this.supportNum = supportNum;
	}
	public Integer getOpposeNum() {
		return opposeNum;
	}
	public void setOpposeNum(Integer opposeNum) {
		this.opposeNum = opposeNum;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", type=" + type + ", writer=" + writer + ", publishtime="
				+ publishtime + ", content=" + content + ", commentCount=" + commentCount + ", Browsingamount="
				+ Browsingamount + ", supportNum=" + supportNum + ", opposeNum=" + opposeNum + "]";
	}

}
