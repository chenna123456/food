package com.oracleoaec.entity;
/**
 * 文章收藏实体类
 * @author 陈娜
 *
 */
public class ArticleCollection {
	private Integer id;
	private Integer vipId;//用户id
	private Integer articleId;//文章id
	private String articleName;//文章名
	
	public ArticleCollection() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ArticleCollection(Integer id, Integer vipId, Integer articleId, String articleName) {
		super();
		this.id = id;
		this.vipId = vipId;
		this.articleId = articleId;
		this.articleName = articleName;
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

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}


	public String getArticleName() {
		return articleName;
	}


	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}


	public String toString() {
		return "ArticleCollection [id=" + id + ", vipId=" + vipId + ", articleId=" + articleId + ", articleName="
				+ articleName + "]";
	}

	
	
}
