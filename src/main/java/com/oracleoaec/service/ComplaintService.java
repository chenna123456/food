package com.oracleoaec.service;

import java.util.List;

import com.oracleoaec.entity.Complaint;

/**
 * 投诉相关实体类
 * 
 * @author 陈娜
 *
 */
public interface ComplaintService {
	/**
	 * 添加投诉
	 * 调用ComplaintDao中
	 * @param complaint
	 * @return 
	 */
	int addComplaint(String title,String content,String complaintName,
			String gender,int vipId,String address );
	/**
	 * 根据传入的页码及页长，
	 * 调用ComplaintDao中的findComplaint(int page,int pageSize)方法
	 * 获得想要的Complaint集合
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Complaint> findComplaintByPage(int page,int pageSize);
	/**
	 * 通过id查询投诉详情
	 * 调用ComplaintDao中的findComplaintById
	 * @param id
	 * @return
	 */
	Complaint findComplaintById(int id);
	/**
	 * 删除传入的Complaint
	 * @param complaint
	 */
	void deletefindComplaintById(Complaint complaint);
}
