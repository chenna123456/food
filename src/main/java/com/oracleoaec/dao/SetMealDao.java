package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.SetMeal;

/**
 * 套裁类型dao
 * @author 陈娜
 *
 */
public interface SetMealDao {
	/**
	 * 查询数据库中总数据条数
	 * @return
	 */
	int findAllCount();
	/**
	 * 查询数据库中表SetMeal里面的所有字段，
	 * 将所有数据封装为SetMeal对象后，
	 * 添加到list集合众返回
	 * @return
	 */
	List<SetMeal> findAllSetMeal();
	/**
	 * 根据传入的name查询表SetMeal中的数据，
	 * 并且封装为SetMeal对象返回
	 * @param name
	 * @return
	 */
	SetMeal findSetMealByName(String name);
	/**
	 * 通过传入的id,查询SetMeal表中对应的数据，
	 * 并封装为SetMeal对象返回
	 * @param id
	 * @return
	 */
	SetMeal findSetMealById(int id);
	/**
	 * 将传入的SetMeal对象添加到数据库中
	 * @param setMeal
	 */
	void addSetMeal(SetMeal setMeal);
	/**
	 * 根据传入对象的id,修改数据库中对应的信息
	 * @param setMeal
	 */
	void updateSetMeal(SetMeal setMeal);
	/**
	 * 根据传入对象的id,删除数据库中对应的信息
	 * @param setMeal
	 */
	void deleteSetMeal(SetMeal setMeal);
	
}
