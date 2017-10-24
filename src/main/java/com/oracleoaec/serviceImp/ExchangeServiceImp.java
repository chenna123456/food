package com.oracleoaec.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracleoaec.dao.ExchangegiftDao;
import com.oracleoaec.dao.GiftCarDao;
import com.oracleoaec.daoImp.ExchangegiftDaoImp;
import com.oracleoaec.daoImp.GiftCarDaoImp;
import com.oracleoaec.entity.Exchangegift;
import com.oracleoaec.entity.GiftCar;
import com.oracleoaec.service.ExchangeService;

public class ExchangeServiceImp implements ExchangeService {

	public Map<String, Object> findExchangegiftBySelect(String type, String page, String pageSizeS, String minPointS,
			String maxPointS) {
		ExchangegiftDao dao = new ExchangegiftDaoImp();
		int pageNo = 1;
		int pageSize = 4;
		int minPoint = 0;
		int maxPoint = 1000;
		if (page != null && page != "") {
			pageNo = Integer.parseInt(page);
		}
		if (pageSizeS != null && pageSizeS != "") {
			pageSize = Integer.parseInt(pageSizeS);
		}
		if (minPointS != null && minPointS != "") {
			minPoint = Integer.parseInt(minPointS);
		}
		if (maxPointS != null && maxPointS != "") {
			maxPoint = Integer.parseInt(maxPointS);
		}
		int number = dao.findCountByType(type);
		List<Exchangegift> list = dao.findgiftBySelect(type, pageNo, pageSize, minPoint, maxPoint);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("number", number);
		map.put("pages", Math.ceil((double) number / pageSize));
		map.put("list", list);
		return map;
	}

	public List<Exchangegift> findType() {
		ExchangegiftDao dao = new ExchangegiftDaoImp();
		List<Exchangegift> list = dao.findType();
		return list;
	}

	public Exchangegift findGiftBySrc(String src) {
		ExchangegiftDao dao = new ExchangegiftDaoImp();
		Exchangegift ex = dao.findExchangegiftBySrc(src);
		return ex;
	}

	public Map<String, Object> findGiftCarByVipId(String pageS, String pageSizeS, int vipId) {
		ExchangegiftDao dao = new ExchangegiftDaoImp();
		GiftCarDao dao2 = new GiftCarDaoImp();
		List<GiftCar> list = dao2.findGiftCarByVipid(vipId);
		List<Exchangegift> list2 = new ArrayList<Exchangegift>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listgift", list);
		int pageNo = 1;
		int pageSize = 6;
		if (pageS != null && pageS != "") {
			pageNo = (int) Double.parseDouble(pageS);
		}
		if (pageSizeS != null && pageSizeS != "") {
			pageSize = (int) Double.parseDouble(pageSizeS);
		}
		for (int i = 0; i < list.size(); i++) {
			Exchangegift ex = dao.findExchangegift(list.get(i).getGitfId(), pageNo, pageSize);
			list2.add(ex);
		}
		map.put("listExchangegift", list2);
		map.put("pages", Math.ceil((double) list.size() / pageSize));
		return map;
	}

	public List<Exchangegift> findGiftTop(String numberS) {
		int number = 6;
		if (numberS != null && numberS != "") {
			number = (int) Double.parseDouble(numberS);
		}
		ExchangegiftDao dao = new ExchangegiftDaoImp();
		List<Exchangegift> list = dao.findGiftTop(number);
		return list;
	}

	public void addGift(String src, int vipId, String numberS) {
		ExchangegiftDao dao = new ExchangegiftDaoImp();
		GiftCarDao daog = new GiftCarDaoImp();
		Exchangegift ex = dao.findExchangegiftBySrc(src);
		GiftCar gift = new GiftCar();
		Integer giftId = ex.getId();
		try {
			gift.setVipId(vipId);
			gift.setGitfId(giftId);
			int number = (int)(Double.parseDouble(numberS));
			gift.setNumber(number);
			gift.setExchangeDate(new Date());
			ex.setCount(ex.getCount()-number);
			int i = dao.updateCountByid(ex);
			if(i!=-1){
				int j = daog.addGiftCar(gift);
				if(j==-1){
					ex.setCount(ex.getCount()+number);
					dao.updateCountByid(ex);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("类型转换异常" + e);
		}

	}

}
