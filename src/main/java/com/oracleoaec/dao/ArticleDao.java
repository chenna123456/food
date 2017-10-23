package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Article;

/**
 * 文章接口
 * 
 * @author 陈娜
 *
 */
public interface ArticleDao {
	/**
	 * 查询数据库中数据的总条数
	 * @return
	 */
	int findAllCount();
	/**
	 * 查询数据库中满足条件的总条数
	 * @param Type
	 * @return
	 */
	int finCountByType(String Type);
	/**
	 * 通过指定的文章的类型，查询表Article里面的最新的
	 * id及title字段
	 * 进行分页查询
	 * 将查询到的数据封装在Article对象，并添加到list中返回
	 * @param type 文章类型
	 * @param page 页码
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	List<Article> findTitleByType(String type,int page,int pageSize);
	
	/**
	 * 根据文章的id,查询满足条件的Article，
	 * 并封装为Article对象返回
	 * @param id 文章id
	 * @return
	 */
	Article findArticle(int id);
	/**
	 * 根据指定的显示数量，
	 * 调用ArticleDao中的方法获得最热门的前number篇文章
	 * @param number
	 * @return
	 */
	List<Article> findHotArticle(int number);
	/**
	 * 添加传入的文章Article
	 * @param article
	 */
	void addArticle(Article article);
	/**
	 * 根据传入的Article的id
	 * 删除指定的数据
	 * @param article
	 */
	void deleteAricle(Article article);
	/**
	 * 根据传入的Article的id更新文章信息
	 * @param article
	 */
	void updateSricle(Article article);
}
