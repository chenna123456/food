package com.oracleoaec.service;

import java.util.List;

import com.oracleoaec.entity.Optionalfood;
/**
 * 自选定餐Service
 * @author 陈娜
 *
 */
public interface OptionalfoodService {
	/**
	 * 根据传入的餐品类型，最小单价和最大单价，
	 * 及指定页码及页面长度，查询Optionalfood表，
	 * 将查询到的数据封装为Optionalfood对象，
	 * 添加到list集合中返回
	 * @param type
	 * @param minPrice
	 * @param maxPrice
	 * @param page
	 * @param pageSize
	 * @return
	 */
    public List<Optionalfood> findOptionalfoodByPrice(String type,Integer minPrice, Integer maxPrice, Integer page, Integer pageSize);
}
