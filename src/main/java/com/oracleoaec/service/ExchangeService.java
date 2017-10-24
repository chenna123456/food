package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.entity.Exchangegift;

public interface ExchangeService {
	/**
	 * 通过指定的类型，页面，页长，积分范围
	 * 查询符合的Exchangegift集合
	 * @param type
	 * @param page
	 * @param pageSize
	 * @param minPoint
	 * @param maxPoint
	 * @return
	 */
	Map<String, Object> findExchangegiftBySelect(String type,
			String page,String pageSize,String minPoint,String maxPoint);
	/**
	 * 查询兑换礼品的所有种类
	 * @return
	 */
	List<Exchangegift> findType();
	/**
	 * 通过src得到对应的奖品的信息
	 * @param src
	 * @return
	 */
	Exchangegift findGiftBySrc(String src);
	/**
	 * 查询指定vip的礼品车
	 * @param VipId
	 * @return
	 */
	Map<String,Object> findGiftCarByVipId(String page,String pageSize,int VipId);
	/**
	 * 查询兑换数量排名前number的lipin
	 * @param number
	 * @return
	 */
	List<Exchangegift> findGiftTop(String number);
	/**
	 * 添加指定用户加入的兑换礼品
	 * @param vipId
	 * @param number
	 */
	void addGift(String src,int vipId, String number);

}
