package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Exchangegift;

public interface ExchangegiftDao {
	/**
	 * 获得数据表Exchangegift中的总条数
	 * @return
	 */
	int findCount();
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
	Exchangegift findExchangegift(int id);
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
}
