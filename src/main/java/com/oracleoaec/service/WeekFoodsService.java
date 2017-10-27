package com.oracleoaec.service;

import java.util.Map;

public interface WeekFoodsService {
	/**
	 * 获得今天的年、月、日，星期，并分别
	 * 封装在map中
	 * @return
	 */
	Map<String,Object> findNowDate();
}
