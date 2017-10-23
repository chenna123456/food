package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.ArticleCollection;

public interface ArticleCollectionDao {
	/**
	 * 查询表ArticleCollection中对应vipId收藏文章总数
	 * @return
	 */
	int findCountByvipId(int vipId);
	/**
	 * 通过文章id查询表ArticleCollection中收藏该文章的总人数
	 * @param ArticleId
	 * @return
	 */
	int finCountByArticleId(int ArticleId);
	/**
	 * 根据vipId获得该用户收藏的文章中的指定页码和页长的内容 封装为ArticleCollection集合对象返回
	 * 
	 * @param vipId
	 * @return
	 */
	List<ArticleCollection> findArticleCollection(int vipId, 
			int page, int pageSize);
	/**
	 * 将获得的ArticleCollection对象插入到数据库中
	 * @param articleCollection
	 */
	void add(ArticleCollection articleCollection);
	/**
	 * 根据传入的ArticleCollection对象的id删除表中的数据
	 * @param articleCollection
	 */
	void updateArticleCollection(ArticleCollection articleCollection);
	
	
}
