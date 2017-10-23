package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Leavemessage;

/**
 * 留言dao
 * 
 * @author 陈娜
 *
 */
public interface LeavemessageDao {
	/**
	 * 查询所有的留言信息，封装为Leavemessage对象，
	 * 并且添加到list集合中返回
	 * @return
	 */
	List<Leavemessage> findAll();
	/**
	 * 将传入的Leavemessage对象添加到Leavemessage表中
	 * @param leavemessage
	 */
	void addLeavemessage(Leavemessage leavemessage);
	/**
	 * 根据传入的Leavemessage对象的id,
	 * 删除表Leavemessage对应的数据
	 * @param leavemessage
	 */
	void deleteLeavemessage(Leavemessage leavemessage);
}
