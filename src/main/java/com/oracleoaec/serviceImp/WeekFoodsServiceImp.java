package com.oracleoaec.serviceImp;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.oracleoaec.service.WeekFoodsService;

public class WeekFoodsServiceImp implements WeekFoodsService {

	public Map<String, Object> findNowDate() {
		Map<String, Object> map=new HashMap<String, Object>();
		Calendar now=Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		map.put("year", year);
		int month = now.get(Calendar.MONTH)+1;
		map.put("month", month);
		int day = now.get(Calendar.DAY_OF_MONTH);
		map.put("day", day);
		int week = now.get(Calendar.DAY_OF_WEEK)-1;
		map.put("week", week);
		int month_days=0;
		if(month==1||month==3||month==5||month==7||month==8
				||month==10||month==12){
			month_days=31;
		}else if(month==4||month==6||month==9||month==11){
			month_days=31;
		}else if(year%4==0&&year%100!=0){
			month_days=28;
		}else{
			month_days=29;
		}
		map.put("month_days", month_days);
		return map;
	}

}
