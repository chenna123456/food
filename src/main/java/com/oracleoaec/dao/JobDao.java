package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Job;

public interface JobDao {
	/**
	 * 查询总条数
	 * @return
	 */
	public int findCount();
	/**
	 * 分页查询职位
	 * 封装为List返回
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Job> findAllJob(int page,int pageSize);
}
