package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Vip;

/**
 * vipdao接口
 * @author 沐家泽
 *
 */
public interface VipDao {
	/**
	 * 查询数据表Vip中的总条数
	 * @return
	 */
	int findAllcount();
	/**
	 * 根据指定的页号和页长，
	 * 查询数据表Vip中的数据，
	 * 并且封装为Vip对象，添加到list集合中返回
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<Vip> findVip(int page,int pageSize);
	/**
	 * 登陆接口
	 * 通过传入的用户名和密码，查询vip表中的所有字段，看vip表是否存在该用户，
	 * 若存在，则将查询到的vip用户封装为vip对象返回
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Vip FindVipInfo(String name, String pwd);// 会员登录

	/**
	 * 注册接口
	 * 传入封装好的vip对象，然后解析该对象，将该对象插入到vip表中，
	 * 无返回值
	 * @param vip
	 */
	public void InsertVipInfo(Vip vip);// 会员注册
	
	/**
	 * 通过制定的id,查询数据表Vip中的数据，
	 * 并且封装为Vip对象返回
	 * @param id
	 * @return
	 */
	Vip findVipById(int id);
	
	/**
	 * 修改会员信息
	 * 传入封装好的vip对象，
	 * 解析该vip对象，
	 * 根据vip的id,更新对应的数据
	 * @param vip
	 */
	public void UpdataVipInfo(Vip vip);// 会员修改信息
	public Boolean findPhoneUsed(String phone);
}
