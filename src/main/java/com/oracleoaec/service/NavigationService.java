package com.oracleoaec.service;

import java.util.List;
import java.util.Map;

import com.oracleoaec.entity.Navigation;

public interface NavigationService {
	/**
	 * 查询所有的导航栏信息
	 * @return
	 */
	List<Navigation> findAllNavigation();
	/**
	 * 查询指定的信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	Map<String,Object> findjob(String page,String pageSize);
}
