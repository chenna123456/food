package com.oracleoaec.dao;

import java.util.List;

/**
 * 订单餐品详情接口
 * @author 陈娜
 */
import com.oracleoaec.entity.Orderfood;

public interface OrderFoodDao {
	/**
	 * 该方法通过指定的orderNo查询订单食物详情表(Orderfood)里面的，满足指定订单的食物，
	 * 并将这些食物添加到list里面返回
	 * @param orderNo
	 * @return
	 */
	List<Orderfood> findOrderFoodByorderNo(String orderNo);
	/**
	 * 将传入的OrderFood对象添加到数据表OrderFood中
	 * @param orderFood
	 */
	void addOrderFood(Orderfood orderFood);
	/**
	 * 根据传入的Orderfood对象的id更新数据表Orderfood中的数据
	 * @param orderFood
	 */
	void updateOrderFood(Orderfood orderFood);
	/**
	 * 根据传入的订单号，删除数据表Orderfood中对应的数据
	 * @param orderNo
	 */
	void deleteOrderfood(String orderNo);
	
}
