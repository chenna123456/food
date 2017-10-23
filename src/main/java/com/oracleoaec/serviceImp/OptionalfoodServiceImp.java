package com.oracleoaec.serviceImp;

import java.util.List;

import com.oracleoaec.dao.OptionalfoodDao;
import com.oracleoaec.entity.Optionalfood;
import com.oracleoaec.service.OptionalfoodService;
import com.oracleoaec.util.FactoryDao;

public class OptionalfoodServiceImp implements OptionalfoodService{

	FactoryDao fa=new FactoryDao();
    public List<Optionalfood> findOptionalfoodByPrice(String type,Integer minPrice, Integer maxPrice, Integer page, Integer pageSize) {
	OptionalfoodDao dao=fa.getOptionalfoodDao();
	List<Optionalfood> list = dao.findOptionalfoodByPrice(type,minPrice, maxPrice, page, pageSize);
	return list;
    }

}
