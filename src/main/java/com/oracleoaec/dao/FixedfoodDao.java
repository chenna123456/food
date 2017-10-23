package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Fixedfood;
/**
 * 固定套餐Dao
 * @author 杨佐朝
 *
 */
public interface FixedfoodDao {
	/**
	 * 获得数据表Fixedfood中的总条数
	 * @return
	 */
	int findAllCount();
	 /**
     * 根据套餐名称和套餐类型查库存
     * @param foodName
     * @param type
     * @return
     */
    public Integer findFixedfoodCount(String foodName,String type);
	/**
	 * 根据套餐类型查询
	 * @param type
	 * @return
	 */
    public List<Fixedfood> findFixedfoodByType(String type);
    /**
     * 根据传入的餐品类型和页码，页面长度，查询Fixedfood表中的数据
     * 并且封装为Fixedfood对象，然后添加到List集合中，并返回
     * @param type
     * @param page
     * @param pageSize
     * @return
     */
    List<Fixedfood> findFixedfoodByTypeAndPage(String type,int page,int pageSize);
}
