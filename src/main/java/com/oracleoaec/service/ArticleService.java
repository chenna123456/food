package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.entity.Article;
import com.oracleoaec.entity.ArticleCollection;

/**
 * 文章相关service
 * @author 陈娜
 *
 */
public interface ArticleService {
	/**
	 * 查询指定类型的总条数
	 * 调用ArticleDao中的finCountByType(String Type)
	 * @param type
	 * @return
	 */
	int findCount(String type);
	/**
	 * 网站公告
	 * 
	 * 根据指定的显示数量，
	 * 调用ArticleDao中的findHotArticle(int number)方法
	 * 获得最热门的前number篇文章
	 * @param number
	 * @return
	 */
	List<Article> findHotArticle(int number);
	/**
	 * 饮食文化
	 * 
	 * 通过传入的类型，及数量
	 * 调用ArticleDao中的findTitleByType(String type,int page,int pageSize)方法
	 * 查询数据库中对应类型的最新的number篇文章的集合，并返回
	 * @param type
	 * @return
	 */
	List<Article> findArticleByType(String type,int number);
	/**
	 * 
	 * 更多文章处使用
	 * 
	 * 通过制定的类型，页码，页长，
	 * 调用ArticleDao中的findTitleByType(String type,int page,int pageSize)方法
	 * 查询数据库中对应类型的最新的文章的集合返回
	 * @param type
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Article> findArticleByPage(String type,int page,int pageSize);
	/**
	 * 文章详情时使用
	 * 
	 * 通过指定文章的id
	 * 调用ArticleDao中的findArticle(int id)方法
	 * 获得对应的文章，并且返回
	 * 
	 * @param id
	 * @return
	 */
	Article findArticleById(int id);
	/**
	 * 
	 * 文章评论详情
	 * 
	 * 通过指定文章的id
	 * 调用VipcommentDao接口中的findCount()、
	 * findVipcomment(int page,int PageSize)方法获得留言总条数及指定页面的具体留言信息
	 * 将他们封装好添加到map中返回
	 * 
	 * @param id
	 * @return
	 */
	Map<String,Object> findCommentDao(int articleId);
	/**
	 * 通过调用ArticleCollectionDao接口中
	 * add(ArticleCollection articleCollection)方法，
	 * 将传入的ArticleCollection对象添加到数据表中
	 * @param articleCollection
	 */
	void addArticleCollection(ArticleCollection articleCollection);
}
