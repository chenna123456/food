package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Exchangegift;
import com.oracleoaec.entity.GiftCar;

public interface ExchangegiftDao {
	/**
	 * 获得数据表Exchangegift中的总条数
	 * @return
	 */
	int findCount();
	/**
	 * 通过传入的类型，查询总条数
	 * @param type
	 * @return
	 */
	int findCountByType(String type);
	/**
	 * 根据指定的页码和每页的长度，查询表Exchangegift
	 * 并将查询到的数据封装为Exchangegift对象添加到list集合中
	 * @param page
	 * @param PageSize
	 * @return
	 */
	List<Exchangegift> findExchangegiftBypage(int page,int PageSize);
	/**
	 * 通过制定的id，查询数据表Exchangegift中对应的Exchangegift对象，并返回
	 * @param id
	 * @return
	 */
	Exchangegift findExchangegift(int id,int page,int pageSize);
	/**
	 * 通过制定的src，查询数据表Exchangegift中对应的Exchangegift对象，并返回
	 * @param id
	 * @return
	 */
	Exchangegift findExchangegiftBySrc(String src);
	/**
	 * 通过传入的类型type,page,pageSize,minPoint,maxPoint,
	 * 检索数据表Exchangegift中满足条件的数据，
	 * 并且封装为Exchangegift对象添加到list里面返回
	 * 
	 * 注意：我并不会传入所有的数据，比如说，当只传入类型，
	 * 并没有传入页号，或者，只传入最小积分，其他的没有
	 * @param type
	 * @param page
	 * @param pageSize
	 * @param minPoint
	 * @param maxPoint
	 * @return
	 */
	List<Exchangegift> findgiftBySelect(String type,int page,
			int pageSize,int minPoint,int maxPoint);
	/**
	 * 去重查询表Exchangegift中的所有类型
	 * @return
	 */
	List<Exchangegift> findType();
	/**
	 * 将传入的Exchangegift对象添加到Exchangegift表中
	 * @param exchangegift
	 */
	void addExchangegift(Exchangegift exchangegift);
	/**
	 * 根据各个礼品的兑换次数，查询排行在前number个的Gigt
	 * 的id及名称，并封装为Exchangegift对象返回
	 * @param number
	 * @return
	 */
	List<Exchangegift> findGiftTop(int number);
	
	/**
	 * 更新Exchangegift对象
	 * @param src
	 */
	int  updateCountByid(Exchangegift  ex);

}
