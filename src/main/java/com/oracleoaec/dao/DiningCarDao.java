package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.DiningCar;

/**
 * 餐车dao
 * @author 陈娜
 *
 */
public interface DiningCarDao {
	/**
	 * 根据传入的vipId查询该vip对应的餐品，
	 * 并封装为 DiningCar对象，添加到list集合中，
	 * 并返回
	 * @param vipId
	 * @return
	 */
	List<DiningCar> findFood(int vipId);
	/**
	 * 将传入的DiningCar对象插入到数据库diningCar中
	 * @param diningCar
	 * @return
	 */
	void addDining(DiningCar diningCar);
	/**
	 * 根据传入的DiningCar对象的id值，更新diningCar中对应的内容
	 * @param diningCar
	 * @return
	 */
	List<DiningCar> updateDining(DiningCar diningCar);
	/**
	 * 根据传入的DiningCar对象的id值，删除diningCar中对应的内容
	 * @param diningCar
	 * @return
	 */
	void deleteDining(DiningCar diningCar);
}
