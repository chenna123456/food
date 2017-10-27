package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.PublicfoodDaoImp;
import com.oracleoaec.entity.Publicfood;

public class LoadWeekFoodServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String pages=request.getParameter("page");
		
		int  page=1;
		if(pages!=null&&!pages.equals("")){
			page=Integer.parseInt(pages);
		}
		PublicfoodDaoImp p =new PublicfoodDaoImp();
		List<Publicfood> list =p.pagefind(page);
		int num = p.countfood();
		int cpage= num%6==0? num/6:num/6+1;
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("list", list);
		map.put("cpage", cpage);
		response.getWriter().write(JSON.toJSONString(map));
		
		
		
	}
	

}
