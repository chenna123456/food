package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Complaint;

/**
 * 投诉dao
 * 
 * @author 陈娜
 *
 */
public interface ComplaintDao {
	/**
	 * 查询数据库中投诉的总条数
	 * @return
	 */
	int findAllCount();
	/**
	 * 根据指定的页码，页长
	 * 查询表Complaint中的数据
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Complaint> findComplaint(int page,int pageSize);
	/**
	 * 根据id查找对应的投诉
	 * @param id
	 * @return
	 */
	Complaint findComplaintById(int id);
	/**
	 * 把传入的Complaint对象添加到Complaint表中
	 * @param complaint
	 * @return 
	 */
	int addComplaintDao(Complaint complaint);
	/**
	 * 根据传入的Complaint对象的id删除数据库Complaint对应的内容
	 * @param complaint
	 */
	void deleteComplaint(Complaint complaint);
	
	
}
