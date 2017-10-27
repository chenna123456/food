package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.LeavemessageDaoImp;
import com.oracleoaec.entity.Leavemessage;
/**
 * 查找所有的的留言信息
 * @author 刘飞
 * @date 2017年10月23日
 */
public class FindByPageServlet extends HttpServlet{

	private static final long serialVersionUID = 2691152621793126894L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		int page = 0;
		String pageS = request.getParameter("page");
		if (pageS!=null && pageS!="") {
			page = Integer.parseInt(pageS); 
		}else {
			page=1;
		}
		int pageSize = 8; 
	
		LeavemessageDaoImp imp = new LeavemessageDaoImp();
		int count = imp.count();
		int pages = count%pageSize==0 ? count/pageSize : count/pageSize+1;
		List<Leavemessage> list = imp.findByPage(page, pageSize);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pages", pages);
		map.put("list", list);
		map.put("count", count);
		response.getWriter().write(JSON.toJSONString(map));
	}
}
