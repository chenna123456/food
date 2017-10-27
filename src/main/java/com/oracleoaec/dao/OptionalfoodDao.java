package com.oracleoaec.dao;

import java.util.List;

import com.oracleoaec.entity.Optionalfood;
/**
 * 自选点餐dao接口
 * @author 杨佐朝
 *
 */
public interface OptionalfoodDao {
    
    //首页根据价格和类型分页查询的菜谱
    public List<Optionalfood> findOptionalfoodByPrice(String type,Integer minPrice,Integer maxPrice,Integer page,Integer pageSize);
  
    //首页根据类型分页查询的菜谱      -- 单点餐品/点心小吃
    public List<Optionalfood> findOptionalfoodByType(String type,Integer page,Integer pageSize);
    
    //查询菜名查库存
    public Integer findOptionalfoodCount(String foodName);
    /**
     * 根据传入的optionalfood对象的id更新表 Optionalfood
     * 中的数据
     * @param optionalfood
     */
    void updateOptionalfood(Optionalfood  optionalfood);
    /**
     * 根据传入的optionalfood对象的id删除表 Optionalfood
     * 中的数据
     * @param optionalfood
     */
    void deleteOptionalfood(Optionalfood  optionalfood);
    /**
     * 将传入的optionalfood对象添加到表 Optionalfood中
     * @param optionalfood
     */
    void addOptionalfood(Optionalfood  optionalfood);

	public Integer findListSize(String type, int parseInt, int parseInt2);

}
