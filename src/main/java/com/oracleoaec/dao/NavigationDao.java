package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Navigation;

/**
 * 导航栏dao接口
 * 
 * @author 陈娜
 *
 */
public interface NavigationDao {
	/**
	 * 查询Navigation表中的所有数据的Title
	 * 封装为Navigation对象，并添加到list集合中
	 * 将该list集合返回
	 * @return
	 */
	List<Navigation> findTitle();
	/**
	 * 根据指定的title,查询表Navigation中
	 * 对应的数据内容，并封装为Navigation对象返回
	 * @param title
	 * @return
	 */
	Navigation findContent(String title);
	/**
	 * 将传入的Navigation对象，添加到数据表Navigation中
	 * @param navigation
	 */
	void addNavigation(Navigation navigation);
	/**
	 * 根据传入的Navigation对象的id更新数据表Navigation
	 * 中的内容
	 * @param navigation
	 */
	void updateNavigation(Navigation navigation);
	/**
	 * 根据传入的Navigation对象的id删除数据表Navigation
	 * 中的数据
	 * @param navigation
	 */
	void deleteNavigation(Navigation navigation);
}
