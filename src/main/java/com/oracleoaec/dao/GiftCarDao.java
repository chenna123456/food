package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.GiftCar;

/**
 * 礼品车Dao
 * @author 陈娜
 *
 */
public interface GiftCarDao {
	/**
	 * 根据传入的vipid，查询该用户的所有的兑换记录，
	 * 并封装在GiftCar对象中返回
	 * @param vipid
	 * @return
	 */
	List<GiftCar> findGiftCarByVipid(int vipid);
	/**
	 * 根据传入的gitfid，查询该用户的所有的兑换记录，
	 * 并封装在GiftCar对象中返回
	 * @param gitfid
	 * @return
	 */
	List<GiftCar> findGiftCarBygiftid(int gitfid);
	/**
	 * 根据vipid和gitfid查询对应的GiftCar，并返回
	 * @param vipid
	 * @param gitfid
	 * @return
	 */
	GiftCar findGiftCar(int vipid,int gitfid);
	/**
	 * 将传入的GiftCar对象添加到GiftCar表中
	 * @param giftCar
	 * @return 
	 */
	int addGiftCar(GiftCar giftCar);
	/**
	 * 根据传入的GiftCar对象的id,删除表GiftCar中对应的对象
	 * @param giftCar
	 */
	void deleteGiftCar(GiftCar giftCar);
	/**
	 * 根据传入的GiftCar对象的id进行更新表GiftCar中的数据
	 * @param giftCar
	 */
	void updateGiftCar(GiftCar giftCar);
	
}
