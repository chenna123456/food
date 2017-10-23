package com.oracleoaec.dao;

import com.oracleoaec.entity.Orderlistinfo;
/**
 * 订单信息接口
 * @author 陈娜
 *
 */
public interface OrderListInfoDao {
	/**
	 * 通过指定的订单编号和手机号，查询OrderListInfo表的所有字段，
	 * 并封装成OrderListInfo对象返回
	 * @param orderNo
	 * @return
	 */
	Orderlistinfo findOrderInfoByOrderNo(String orderNo,String phone);
	
	/**
	 * 通过指定的VipId，查询OrderListInfo表的所有字段，
	 * 并封装成OrderListInfo对象返回
	 * @param vipId
	 * @return
	 */
	Orderlistinfo findOrderInfoByVipId(int vipId);
	/**
	 * 根据传入的Orderlistinfo对象的id更新订单内容
	 * @param orderlistinfo
	 */
	void OrderInfo(Orderlistinfo orderlistinfo);
	/**
	 * 将传入的Orderlistinfo对象添加到Orderlistinfo表中
	 * @param orderlistinfo
	 */
	void addOrderlistinfo(Orderlistinfo orderlistinfo);
	
}
