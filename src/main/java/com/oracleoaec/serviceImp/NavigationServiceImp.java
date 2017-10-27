package com.oracleoaec.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracleoaec.dao.JobDao;
import com.oracleoaec.dao.NavigationDao;
import com.oracleoaec.daoImp.JobDaoImp;
import com.oracleoaec.daoImp.NavigationDaoImp;
import com.oracleoaec.entity.Job;
import com.oracleoaec.entity.Navigation;
import com.oracleoaec.service.NavigationService;

public class NavigationServiceImp implements NavigationService {

	public List<Navigation> findAllNavigation() {
		NavigationDao dao=new NavigationDaoImp();
		List<Navigation> list = dao.findAllNavigation();
		return list;
	}

	public Map<String, Object> findjob(String pageS, String pageSizeS) {
		JobDao dao=new JobDaoImp();
		Map<String, Object> map=new HashMap<String, Object>();
		int page=1;
		int pageSize=4;
		if(pageS!=null&&pageS!=""){
			page=(int)Double.parseDouble(pageS);
		}
		if(pageSizeS!=null&&pageSizeS!=""){
			pageSize=(int)Double.parseDouble(pageSizeS);
		}
		int count = dao.findCount();
		List<Job> list = dao.findAllJob(page, pageSize);
		map.put("total", count);
		map.put("pages", Math.ceil((double)count/pageSize));
		map.put("list", list);
		map.put("pageSize", pageSize);
		map.put("page", page);
		return map;
	}

}
