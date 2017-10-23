package com.oracleoaec.service;

import java.util.List;

import com.oracleoaec.entity.Leavemessage;

/**
 * 留言service
 * @author 陈娜
 *
 */
public interface LeavemessageService {
	/**
	 * 查询Leavemessage表的所有数据的所有字段所有字段，
	 * 并把所有数据封装为Leavemessage对象，添加到list集合中，
	 * 返回list集合
	 * @return
	 */
List<Leavemessage> findLeavemess();
}
