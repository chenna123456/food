 package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Combinationfood;

/**
 * 组合套餐Dao
 * @author 杨佐朝
 *
 */
public interface CombinationfoodDao {
	/**
	 * 查询数据库中总条数
	 * @return
	 */
	int findAllCount();
	/**
	 * 按照数据库中满足满足指定类型的总条数
	 * @param type
	 * @return
	 */
	int findCountType(String type);
	 //按照type查询分类
    public List<Combinationfood> findCombinationfoodByType(String type);
    /**
     * 根据传入的组合套餐的对象
     * 添加数据表Combinationfood对应的内容
     * @param combination
     */
    void addCombinationfood(Combinationfood combination);
    /**
     * 根据传入的组合套餐的对象的id
     * 更新数据库Combinationfood
     * @param combination
     */
    void updateCombinationfood(Combinationfood combination);
    /**
     * 根据传入的组合套餐的对象的id
     * 删除数据表Combinationfood对应的内容
     * @param combination
     */
    void deleteCombinationfood(Combinationfood combination);
}
