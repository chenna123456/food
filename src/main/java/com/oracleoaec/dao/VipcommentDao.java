package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Vipcomment;

/**
 * 评论dao
 * 评论信息查询都按时间排序后获得
 * @author 陈娜
 *
 */
public interface VipcommentDao {
	/**
	 * 查询数据库中的总条数
	 * @return
	 */
	int findCount();
	/**
	 * 根据指定的页号和页长，
	 * 查询表Vipcomment中的数据
	 * 并且把查询得到的数据封装为Vipcomment对象，
	 * 添加到list集合中返回
	 * @param page
	 * @param PageSize
	 * @return
	 */
	List<Vipcomment> findVipcomment(int page,int PageSize);
	/**
	 * 将传入的Vipcomment对象添加到Vipcomment表中
	 * @param vipcomment
	 * @return 
	 */
	int addVipcomment(Vipcomment vipcomment);
	/**
	 * 根据传入的Vipcomment对象中的id,
	 * 删除数据表Vipcomment中的数据
	 * @param vipcomment
	 */
	void deleteVipcomment(Vipcomment vipcomment);
}
