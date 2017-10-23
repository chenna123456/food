package com.oracleoaec.service;

import java.util.Map;

/**
 * 订单查询service
 * @author 陈娜
 *
 */
public interface QueryOrderService {
	/**
	 * 该service完成订单信息的查询和订单菜品详情的查询
	 * 将查询出来的订单信息和订单菜品详情信息放在map中，返回
	 * 订单信息的主键为：order
	 * 订单菜品信息的主键为：orderFood
	 * @param orderNo
	 * @param vipName
	 * @return
	 */
	Map<String,Object> findOrder(String orderNo,String vipName);

}
